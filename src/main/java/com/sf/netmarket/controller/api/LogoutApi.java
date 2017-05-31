package com.sf.netmarket.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.viewbean.ValidateInfo;

@RestController
@RequestMapping("/logout")
public class LogoutController {

  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  public ValidateInfo logout(@RequestParam("accessToken") String accessToken) {
    return new ValidateInfo("13", "122","登陆成功");
  }
  
  
}
