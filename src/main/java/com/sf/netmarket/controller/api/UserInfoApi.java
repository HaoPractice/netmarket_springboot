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
import com.sf.netmarket.mapper.UserInfoMapper;
import com.sf.netmarket.model.UserInfo;
import com.sf.netmarket.viewbean.UserInfoViewBean;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoApi extends AbstractSecurityController{
  @Autowired
  private UserInfoMapper UserInfoMapper;
  
  @GetMapping("{id}")
  public UserInfoViewBean getUserInfoById(@PathVariable Long id) {
    UserInfo selectByPrimaryKey = UserInfoMapper.selectById(id);
    if (selectByPrimaryKey == null) {
      return null;
    }
    return new UserInfoViewBean(selectByPrimaryKey.getUsername(), selectByPrimaryKey.getUserId().toString());
  }
  
  @GetMapping("")
  public UserInfoViewBean getUserInfo(String name) {
    if (name == null) {
      throw new UserNotLoginException();
    }
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    logger.debug("",authentication);
    return new UserInfoViewBean("13", name);
  }
  
}
