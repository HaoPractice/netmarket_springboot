package com.sf.netmarket.viewbean;

import java.io.Serializable;

/**
 * 给页面返回用户信息
 * @author hao19
 *
 */
public class UserInfoViewBean implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String username;
  private String userId;

  public UserInfoViewBean() {}

  public UserInfoViewBean(String username, String userId) {
    this();
    this.username = username;
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public String getUserId() {
    return userId;
  }

  @Override
  public String toString() {
    return "UserInfo [username=" + username + ", userId=" + userId + "]";
  }
}
