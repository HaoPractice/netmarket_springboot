package com.sf.netmarket.viewbean;

import java.io.Serializable;

public class ValidateInfo implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String accessToken;
  private String userId;
  private String msg;

  public ValidateInfo() {}

  public ValidateInfo(String accessToken, String userId, String msg) {
    this();
    this.accessToken = accessToken;
    this.userId = userId;
    this.msg = msg;
  }

  public String getUsername() {
    return accessToken;
  }

  public String getSecurityId() {
    return userId;
  }

  public String getMsg() {
    return msg;
  }
}
