package com.sf.netmarket.controller.api.vo;

public enum CommonViewResult implements ViewResult{
	SUCCESSED(0,""),FAILED(-1,"");
	private String msg;
	private int code;

	CommonViewResult(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	@Override
	public int getCode() {
		return code;
	}
	@Override
	public String getMsg() {
		return msg;
	}
}
