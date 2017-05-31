package com.sf.netmarket.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.viewbean.ValidateInfo;

@RestController
@RequestMapping("/login")
public class LoginController {

  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  @RequestMapping("/{identificationString}")
  public ValidateInfo login(@PathVariable String identificationString,@RequestParam String password) {
    return new ValidateInfo("13", "122","登陆成功");
  }
}
