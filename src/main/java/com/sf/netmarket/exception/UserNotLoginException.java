package com.sf.netmarket.exception;

public class UserNotLoginException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String fromPath;
  private Integer code;
  private String msg;

  public String getFromPath() {
    return fromPath;
  }

  public void setFromPath(String fromPath) {
    this.fromPath = fromPath;
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
    return "UserNotLoginException [fromPath=" + fromPath + ", code=" + code + ", msg=" + msg + "]";
  }

}
