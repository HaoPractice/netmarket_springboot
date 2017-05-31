package com.sf.netmarket.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.bizenum.ClientEnum;
import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.service.AuthService;

@RestController
@RequestMapping("/api/logout")
public class LogoutApi extends AbstractSecurityController {

  @Autowired
  AuthService authService;

  private static enum LogoutResult {
    SUCCESS, NOT_LOGIN
  }

  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  public LogoutResult logout(@RequestParam("accessToken") String accessToken,
      HttpServletRequest request, HttpServletResponse response) {
    
    authService.logout(request, response);
    // 删除保存的accessToken
    authService.removeAuthentication(ClientEnum.WEB_PC, getAuthedUserId());
    return LogoutResult.SUCCESS;
  }


}
