package com.sf.netmarket.controller.freemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sf.netmarket.configs.MybatisConfig;
import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.mapper.UserInfoMapper;

@Controller
@RequestMapping("")
public class LoginController extends AbstractSecurityController {

  @Autowired
  UserInfoMapper userInfoMapper;
  @Autowired
  MybatisConfig mybatisConfig;

  @RequestMapping({"login"})
  public ModelAndView loginPage() {
    // 已登录用户，不进行登陆操作
    if (getUserId() != null) {
      return new ModelAndView("/index");
    }
    ModelAndView modelAndView = new ModelAndView("/login");
    String lastLoginUser = loginIdentifyString();
    if (lastLoginUser != null) {
      modelAndView.addObject("lastLoginUser", lastLoginUser);
    }
    return modelAndView;
  }
}
