package com.sf.netmarket.bizenum;

public enum LoginType {
  TEL("手机注册"), EMAIL("电子邮件注册"), NO_IDENTIFY("无认证"), ANONYMOUS("匿名");
  String message;

  private LoginType(String message) {
    this.message = message;
  }
  
}
