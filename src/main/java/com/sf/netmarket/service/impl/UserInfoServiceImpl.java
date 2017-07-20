package com.sf.netmarket.service.impl;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.netmarket.mapper.UserInfoMapper;
import com.sf.netmarket.model.UserInfo;
import com.sf.netmarket.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
  
  @Autowired
  UserInfoMapper userInfoMapper;
  @Override
  public @Nullable UserInfo getUserById(long id) {
	UserInfo customer = userInfoMapper.selectById(id);
    return customer;
  }
}
