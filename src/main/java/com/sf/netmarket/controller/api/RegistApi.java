package com.sf.netmarket.controller.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.controller.api.vo.RegistViewResult;
import com.sf.netmarket.service.RegistService;
import com.sf.netmarket.service.model.RegistResult;
import com.sf.netmarket.viewbean.RegistInfo;
import com.sf.netmarket.viewbean.ViewResultBean;
import com.sf.utils.ValidateUtil;

@RestController
@RequestMapping("/api/regist")
public class RegistApi extends AbstractSecurityController {

  @Autowired
  private RegistService registService;

  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  @PreAuthorize("hasRole('FFF')")
  public ViewResultBean<?> regist(@RequestBody RegistInfo registInfo) {

    String email = registInfo.getBindMail();
    if (StringUtils.isBlank(email)) {
      return ViewResultBean.of(RegistViewResult.BLANK_ACCOUNT);
    }
    if (StringUtils.isBlank(registInfo.getUsername())) {
      return ViewResultBean.of(RegistViewResult.BLANK_NAME, null);
    }

    if (StringUtils.isBlank(registInfo.getPassword())) {
      return ViewResultBean.of(RegistViewResult.BLANK_PWD);
    }
    if (!ValidateUtil.isEmailAddr(email)) {
      return ViewResultBean.of(RegistViewResult.BLANK_ACCOUNT);
    }
    RegistResult doRegist = registService.doRegist(registInfo);
    return ViewResultBean.of(RegistViewResult.of(doRegist.result()));
  }

}
