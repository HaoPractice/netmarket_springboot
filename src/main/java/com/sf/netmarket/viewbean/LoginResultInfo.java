package com.sf.netmarket.viewbean;

import java.io.Serializable;

import com.sf.netmarket.bizenum.LoginResult;

/**
 * 用户登陆的验证结果
 * @author hao19
 *
 */
public class LoginResultInfo implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String accessToken;
  private Long userId;
  private LoginResult loginResult;
  private String message;

  private LoginResultInfo() {}

  public static LoginResultInfo success(String accessToken, Long userId, LoginResult loginResult) {
    return new LoginResultInfo(accessToken, userId, loginResult);
  }
  public static LoginResultInfo err(LoginResult loginResult) {
    return new LoginResultInfo(null, null, loginResult);
  }
  public LoginResultInfo(String accessToken, Long userId, LoginResult loginResult) {
    this();
    this.accessToken = accessToken;
    this.userId = userId;
    if (loginResult!= null) {
      this.loginResult = loginResult;
      this.message = loginResult.getMessage();
    }
  }

  public String getMessage() {
    return message;
  }
  public String getAccessToken() {
    return accessToken;
  }

  public Long getUserId() {
    return userId;
  }

  public LoginResult getLoginResult() {
    return loginResult;
  }
}
