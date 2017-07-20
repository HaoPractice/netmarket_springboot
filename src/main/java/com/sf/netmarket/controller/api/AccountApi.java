package com.sf.netmarket.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.controller.api.vo.BaseViewObject;
import com.sf.netmarket.controller.api.vo.CommonViewResult;
import com.sf.netmarket.mapper.UserIdentificationMapper;
import com.sf.netmarket.model.UserIdentification;
import com.sf.netmarket.model.UserIdentificationExample;

@RestController
@RequestMapping("/api/account")
public class AccountApi extends AbstractSecurityController{
  @Autowired
  private UserIdentificationMapper identificationMapper;
  @GetMapping("isValidEmail")
  public BaseViewObject<Boolean> getUserInfoById(@RequestParam("m") String emailToValid) {
	System.out.println(emailToValid);
	UserIdentificationExample example = new UserIdentificationExample();
	example.createCriteria().andIdentifyEqualTo(emailToValid).andBindedEqualTo(true);
	List<UserIdentification> selectByExample = identificationMapper.selectByExample(example);
	if (selectByExample.isEmpty()) {
		return BaseViewObject.of(CommonViewResult.SUCCESSED, true);
	}
	
	return BaseViewObject.of(CommonViewResult.SUCCESSED, false);
  }
  
}
