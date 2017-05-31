package com.sf.netmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;
import com.sf.netmarket.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
  
  @Autowired
  CustomerMapper customerMapper;
  @Override
  public Customer getUserById(long id) {
    Customer customer = customerMapper.selectByPrimaryKey(id);
    if (customer == null) {
      return null;
    }
    return customer;
  }
}
