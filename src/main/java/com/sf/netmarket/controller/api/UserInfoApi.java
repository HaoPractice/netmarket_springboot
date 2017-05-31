package com.sf.netmarket.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.exception.UserNotLoginException;
import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;
import com.sf.netmarket.viewbean.UserInfo;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoApi extends AbstractSecurityController{
  @Autowired
  private CustomerMapper customerMapper;
  
  @GetMapping("{id}")
  public UserInfo getUserInfoById(@PathVariable Long id) {
    Customer selectByPrimaryKey = customerMapper.selectByPrimaryKey(id);
    if (selectByPrimaryKey == null) {
      return null;
    }
    return new UserInfo(selectByPrimaryKey.getUsername(), selectByPrimaryKey.getUserId().toString());
  }
  
  @GetMapping("")
  public UserInfo getUserInfo(String name) {
    if (name == null) {
      throw new UserNotLoginException();
    }
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    logger.debug("",authentication);
    return new UserInfo("13", name);
  }
  
}
