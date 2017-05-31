package com.sf.netmarket.controller;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sf.netmarket.exception.UserNotLoginException;

/**
 * 供需要登录的页面继承
 * 
 * @author hao19
 *
 */
public abstract class AbstractSecurityController {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 如果已登陆，则返回用户id。否则抛出未登录异常
   */
  protected Long getAuthedUserId() {
    return getUserId(true);
  }

  /**
   * 如果已登陆，则返回用户id。否则，返回null
   * 
   * @return
   */
  protected Long getUserId() {
    return getUserId(false);
  }

  private Long getUserId(boolean needAuth) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null) {
      if (needAuth) {
        throw new UserNotLoginException();
      }
      return null;
    }
    String userId = authentication.getName();
    if (userId == null) {
      if (needAuth) {
        throw new UserNotLoginException();
      }
      return null;
    }
    return Long.valueOf(userId);
  }
  
  /**
   * get loginString from cookie.
   * 
   * @return email or tel to  login
   */
  protected String loginIdentifyString() {
    return "hao";
  }
  protected RequestAttributes requestAttributes() {
    RequestAttributes currentRequestAttributes = RequestContextHolder.currentRequestAttributes();
    return currentRequestAttributes;
  }
  protected ServletRequest servletRequest() {
    RequestAttributes requestAttributes = requestAttributes();
    if (requestAttributes == null) {
      return null;
    }
    if (!(requestAttributes instanceof ServletRequestAttributes)) {
      return null;
    }
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
    return servletRequestAttributes.getRequest();
  }
}
