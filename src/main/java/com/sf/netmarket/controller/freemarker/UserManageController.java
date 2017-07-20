package com.sf.netmarket.controller.freemarker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sf.netmarket.mapper.UserInfoMapper;
import com.sf.netmarket.model.UserInfo;
import com.sf.netmarket.model.UserInfoExample;

@Controller
@RequestMapping("user")
public class UserManageController {
  @Autowired
  UserInfoMapper userInfoMapper;

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
    UserInfoExample example = new UserInfoExample();
    List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
    UserInfo e = new UserInfo();
    e.setUserId(12L);
    e.setUsername("111name");
    userInfos.add(e);
    ModelAndView modelAndView = new ModelAndView("user/alluser");
    modelAndView.addObject(userInfos);
    UserInfo userInfo = new UserInfo();
    userInfo.setUserId(123L);
    modelAndView.addObject("userInfo",userInfo);
    UserInfo userInfo2 = new UserInfo();
    userInfo2.setUserId(null);
    modelAndView.addObject("userInfo2",userInfo2);
    return modelAndView;
  }
}
