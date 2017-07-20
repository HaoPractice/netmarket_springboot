package com.sf.netmarket.viewbean;

import com.sf.netmarket.controller.api.vo.ViewResult;

/**
 * 用户注册结果
 * @author hao19
 *
 * @param <T>
 */
public class ViewResultBean<T> {
  private String msg;
  private Integer code;
  private T result;
  public String getMsg() {
    return msg;
  }
  public Integer getCode() {
    return code;
  }
  public T getResult() {
    return result;
  }
  @Override
  public String toString() {
    return "ViewResultBean [msg=" + msg + ", code=" + code + ", result=" + result + "]";
  }
  public ViewResultBean(String msg, Integer code, T result) {
    super();
    this.msg = msg;
    this.code = code;
    this.result = result;
  }
  public ViewResultBean(ViewResult viewResult, T result) {
	  super();
	  this.msg = viewResult.getMsg();
	  this.code = viewResult.getCode();
	  this.result = result;
  }
  
  public static <T>ViewResultBean<T> of(ViewResult viewResult){
    return new ViewResultBean<>(viewResult, null);
  }
  public static <T>ViewResultBean<T> of(ViewResult viewResult,T t){
    return new ViewResultBean<>(viewResult, t);
  }
}
