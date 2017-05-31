package com.sf.netmarket.viewbean;

public interface Commodity {
  public String getName();
  public String getPicUri();
  public String getCommodityId();
  public String getPrice();
  public String getDiscount();
  public CommodityType getCommodityType();
  int getStock();
}
