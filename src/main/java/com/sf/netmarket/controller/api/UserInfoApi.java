package com.sf.netmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;
import com.sf.netmarket.viewbean.UserInfo;

@RestController
@RequestMapping("userinfo")
public class UserInfoController {
  @Autowired
  private CustomerMapper customerMapper;
  
  @GetMapping("{id}")
  public UserInfo getUserInfoById(@PathVariable Integer id) {
    Customer selectByPrimaryKey = customerMapper.selectByPrimaryKey(id);
    if (selectByPrimaryKey == null) {
      return null;
    }
    return new UserInfo(selectByPrimaryKey.getUsername(), selectByPrimaryKey.getUserId().toString());
  }
  
  @GetMapping("")
  public UserInfo getUserInfo(String name) {
    
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(authentication);
    return new UserInfo("13", name);
  }
  
}
