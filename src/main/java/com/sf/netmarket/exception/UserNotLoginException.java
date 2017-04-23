package com.sf.netmarket.exception;

public class UserNotLoginException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private Integer userId;
  private Integer code;
  private String msg;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "UserNotLoginException [userId=" + userId + ", code=" + code + ", msg=" + msg + "]";
  }

}
