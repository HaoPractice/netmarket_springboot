package com.sf.netmarket.viewbean;

import java.io.Serializable;

public class UserInfo implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String username;
  private String userId;

  public UserInfo() {}

  public UserInfo(String username, String userId) {
    this();
    this.username = username;
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public String getSecurityId() {
    return userId;
  }

  @Override
  public String toString() {
    return "UserInfo [username=" + username + ", userId=" + userId + "]";
  }
}
