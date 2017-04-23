package com.sf.netmarket.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sf.netmarket.exception.UserNotLoginException;
import com.sf.netmarket.viewbean.ViewResultBean;

@ControllerAdvice
public class OnExceptionControllerAdvice {

  @ExceptionHandler
  @ResponseBody
  public <T> ViewResultBean<T> handle(Exception e) {
    if (e instanceof UserNotLoginException) {
      ViewResultBean<T> viewBean = ViewResultBean.error(((UserNotLoginException) e).getMsg(),
          ((UserNotLoginException) e).getCode());
      return viewBean;
    } else {
      ViewResultBean.error(e.getMessage(), -100);
    }
    return null;
  }
}
