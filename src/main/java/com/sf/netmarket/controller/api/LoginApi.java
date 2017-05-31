package com.sf.netmarket.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.viewbean.ValidateInfo;

@RestController
@RequestMapping("/api/login")
public class LoginApi extends AbstractSecurityController{

  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  @RequestMapping("/{identificationString}")
  public ValidateInfo login(@PathVariable String identificationString,@RequestParam String password) {
    return new ValidateInfo("13", "122",LoginResult.SUCCESS);
  }
}
