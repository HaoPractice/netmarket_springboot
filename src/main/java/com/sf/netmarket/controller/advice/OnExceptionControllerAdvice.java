package com.sf.netmarket.controller.advice;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.sf.netmarket.controller.constants.ViewEnum;
import com.sf.netmarket.exception.UserNotLoginException;

@ControllerAdvice
public class OnExceptionControllerAdvice {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(OnExceptionControllerAdvice.class);

  @ExceptionHandler
  public ModelAndView handle(UserNotLoginException e) {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    Object attribute = requestAttributes.getAttribute("", RequestAttributes.SCOPE_REQUEST);
    HashMap<String, Object> model = Maps.newHashMap();
    model.put("fromPage", attribute);
    LOGGER.error("user not logged in",e.getMsg());
    return new ModelAndView("login",model);
  }
  @ExceptionHandler
  public ModelAndView handle(Exception e) {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    Object attribute = requestAttributes.getAttribute("", RequestAttributes.SCOPE_REQUEST);
    HashMap<String, Object> model = Maps.newHashMap();
    model.put("fromPage", attribute);
    LOGGER.error("exception occurred",e);
    return new ModelAndView(ViewEnum.NOT_LOGIN_PAGE.getPath(),model);
  }
}
