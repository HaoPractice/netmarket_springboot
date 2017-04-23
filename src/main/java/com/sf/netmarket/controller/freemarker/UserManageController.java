package com.sf.netmarket.controller.freemarker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.model.Customer;
import com.sf.netmarket.model.CustomerExample;

@Controller
@RequestMapping("user")
public class UserManageController {
  @Autowired
  CustomerMapper customerMapper;

  @GetMapping("alluser/{frompage}/{size}")
  public ModelAndView getAllUser(
      @PathVariable(value = "frompage", required = false) Integer fromPage,
      @PathVariable(value = "size", required = false) Integer size) {
    if (fromPage == null || fromPage < 1) {
      fromPage = 1;
    }
    if(size == null || size < 1) {
      size = 20;
    }
    CustomerExample example = new CustomerExample();
    List<Customer> customers = customerMapper.selectByExample(example);
    Customer e = new Customer();
    e.setUserId(12);
    e.setUsername("111name");
    customers.add(e);
    ModelAndView modelAndView = new ModelAndView("user/alluser");
    modelAndView.addObject(customers);
    return modelAndView;
  }
}
