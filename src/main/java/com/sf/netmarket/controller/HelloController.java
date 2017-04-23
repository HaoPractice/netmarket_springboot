package com.sf.netmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.configs.MybatisConfig;
import com.sf.netmarket.configs.MybatisMapperConfigBean;
import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;
import com.sf.netmarket.viewbean.UserInfo;

@RestController("testController")
@RequestMapping("test")
public class HelloController {
  
  @Autowired
  MybatisMapperConfigBean mybatisMapperConfigBean;
  @Autowired
  CustomerMapper customerMapper;
  @Autowired
  MybatisConfig mybatisConfig;
  
  @RequestMapping("mybatisConfig")
  public UserInfo getUserInfoByName() {
    return new UserInfo(mybatisMapperConfigBean.toString(), "122");
  }
  @RequestMapping("customerMapper")
  public UserInfo getCustomerMapper() {
    Customer selectByPrimaryKey = customerMapper.selectByPrimaryKey(1);
    return new UserInfo(selectByPrimaryKey.toString(), "122");
  }
}
