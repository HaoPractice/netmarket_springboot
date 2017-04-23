package com.sf.netmarket.controller;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;
import com.sf.netmarket.viewbean.RegistInfo;
import com.sf.netmarket.viewbean.ValidateInfo;

@RestController
@RequestMapping("/regist")
public class RegistController {

  @Autowired
  CustomerMapper customerMapper;
  
  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  @Transactional
  public ValidateInfo regist(@RequestBody RegistInfo registInfo) {
    Customer customer = new Customer();
    customer.setUsername(registInfo.getUsername());
    customer.setTelphone(registInfo.getBindTel());
    customer.setPassword(registInfo.getPassword());
    customerMapper.insert(customer);
    return new ValidateInfo( customer.getUsername(),Objects.toString(customer.getUserId()),"登陆成功");
  }
}
