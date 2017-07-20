package com.sf.netmarket.viewbean;

import java.io.Serializable;

import com.sf.netmarket.bizenum.LoginResult;

/**
 * 用户登陆的验证结果
 * @author hao19
 *
 */
public class ValidateInfo implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String accessToken;
  private String userId;
  private LoginResult loginResult;

  private ValidateInfo() {}

  public static ValidateInfo success(String accessToken, String userId, LoginResult loginResult) {
    return new ValidateInfo(accessToken, userId, loginResult);
  }
  public ValidateInfo(String accessToken, String userId, LoginResult loginResult) {
    this();
    this.accessToken = accessToken;
    this.userId = userId;
    this.loginResult = loginResult;
  }

  public String getUsername() {
    return accessToken;
  }

  public String getSecurityId() {
    return userId;
  }

  public LoginResult getLoginResult() {
    return loginResult;
  }
}
