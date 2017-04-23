package com.sf.netmarket.viewbean;

import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = -9074022823821545072L;
  private String bookname;
  private String bookId;

  public Book() {}

  public Book(String bookname, String securityId) {
    this();
    this.bookname = bookname;
    this.bookId = securityId;
  }

  public String getbookname() {
    return bookname;
  }

  public String getSecurityId() {
    return bookId;
  }
}
