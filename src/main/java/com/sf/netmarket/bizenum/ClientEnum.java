package com.sf.netmarket.bizenum;

public enum ClientEnum implements ClientName {
  APP_IPHONE("app_iphone"), APP_IPAD("app_ipad"), WEB_PC("web_pc"), WEB_PHONE("web_phone");

  String name;

  private ClientEnum(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

}
