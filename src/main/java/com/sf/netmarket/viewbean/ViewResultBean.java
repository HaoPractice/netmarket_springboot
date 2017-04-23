package com.sf.netmarket.viewbean;

public class ViewResultBean<T> {
  private String msg;
  private Integer code;
  private T result;
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }
  public T getResult() {
    return result;
  }
  public void setResult(T result) {
    this.result = result;
  }
  @Override
  public String toString() {
    return "ViewResultBean [msg=" + msg + ", code=" + code + ", result=" + result + "]";
  }
  public ViewResultBean(String msg, Integer code, T result) {
    super();
    this.msg = msg;
    this.code = code;
    this.result = result;
  }
  
  public static <T>ViewResultBean<T> error(String msg,Integer code){
    return new ViewResultBean<>(msg,code, null);
  }
}
