package com.sf.netmarket.viewbean;

import java.io.Serializable;

/**
 * 用户提交的注册信息
 * @author hao19
 *
 */
public class RegistInfo implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String bindMail;
  private String bindTel;
  private String age;
  private String username;
  private String password;
  
  public RegistInfo() {}

  public String getBindMail() {
    return bindMail;
  }

  public void setBindMail(String bindMail) {
    this.bindMail = bindMail;
  }

  public String getBindTel() {
    return bindTel;
  }

  public void setBindTel(String bindTel) {
    this.bindTel = bindTel;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "RegistInfo [bindMail=" + bindMail + ", bindTel=" + bindTel + ", age=" + age
        + ", username=" + username + ", password=" + password + "]";
  }

}
