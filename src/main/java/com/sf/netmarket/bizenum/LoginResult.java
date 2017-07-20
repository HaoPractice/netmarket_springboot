package com.sf.netmarket.bizenum;

public enum LoginResult {
  SUCCESS("登陆成功"), ERROR_PASSWORD("密码错误"), NOT_EXIST("用户名不存在"), DISABLED("用户不可用");
  String message;

  private LoginResult(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
