package com.sf.netmarket.controller.constants;

public enum ViewEnum {
  ERROR_PAGE("error"),NOT_LOGIN_PAGE("login");
  private String path;
  private ViewEnum(String path) {
    this.path = path;
  }
  public String getPath() {
    return path;
  }
}
