package com.sf.netmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;

@Service
public class UserInfoServiceImpl {
  
  @Autowired
  CustomerMapper customerMapper;
  
  public String getUsernameById(int id){
    Customer customer = customerMapper.selectByPrimaryKey(id);
    if (customer == null) {
      return null;
    }
    return customer.getUsername();
  }
}
