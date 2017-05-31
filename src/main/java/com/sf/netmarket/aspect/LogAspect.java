package com.sf.netmarket.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {
  
  private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

  
  @Pointcut("execution(public * com.sf.netmarket.controller..*.*(..))")
  public void logAop(){}
  
  @Before("logAop()")
  public void logBefore(JoinPoint joinPoint) {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = requestAttributes.getRequest();
    logger.debug(request.getRequestURL().toString());
    logger.debug(request.getRequestURI());
    logger.debug(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    logger.debug(Arrays.deepToString(joinPoint.getArgs()));
  }
  
  @After("logAop()")
  public void logAfter() {
    logger.debug("after");
  }
  @AfterReturning( returning="object",pointcut="logAop()")
  public void logReturn(Object object) {
    // object为controller返回的数据
    logger.debug(object.toString());
  }
}
