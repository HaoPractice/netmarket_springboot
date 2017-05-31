package com.sf.netmarket.viewbean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品展示缩略图信息
 * @author hao19
 *
 */
public class CommonCommodity implements Commodity,Serializable{

  private static final long serialVersionUID = -9074022823821545072L;
  private String name;
  private String commodityId;
  private BigDecimal price;
  private BigDecimal discount;
  private int stock;
  private String picUri;

  private CommonCommodity() {}

  public CommonCommodity(String bookname, String bookId, BigDecimal price, BigDecimal discount,
      int stock,String picUri) {
    this();
    this.name = bookname;
    this.commodityId = bookId;
    this.price = price;
    this.discount = discount;
    this.stock = stock;
    this.picUri = picUri;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getCommodityId() {
    return commodityId;
  }

  @Override
  public CommodityType getCommodityType() {
    return CommodityType.BOOK;
  }

  @Override
  public String getPrice() {
    return price.toPlainString();
  }

  @Override
  public String getDiscount() {
    return discount.toPlainString();
  }
  
  @Override
  public int getStock() {
    return stock;
  }

  @Override
  public String getPicUri() {
    return picUri;
  }

}
