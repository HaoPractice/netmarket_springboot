package com.sf.netmarket.viewbean;

/**
 * 用户注册结果
 * @author hao19
 *
 * @param <T>
 */
public class ViewResultBean<T> {
  private String msg;
  private Integer code;
  private T result;
  public String getMsg() {
    return msg;
  }
  public Integer getCode() {
    return code;
  }
  public T getResult() {
    return result;
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
  
  public static <T>ViewResultBean<T> success(T t){
    return new ViewResultBean<>(null,0, t);
  }
  public static <T>ViewResultBean<T> error(String msg,Integer code){
    return new ViewResultBean<>(msg,code, null);
  }
}
