package com.sf.netmarket.controller.api.vo;

public class BaseViewObject<Data> {
	private String msg;
	private int code;

	private Data data;
	
	public static <Data> BaseViewObject<Data> of(ViewResult viewResult,Data data) {
		BaseViewObject<Data> baseViewObject = new BaseViewObject<Data>();
		baseViewObject.code = viewResult.getCode();
		baseViewObject.msg = viewResult.getMsg();
		baseViewObject.data = data;
		return baseViewObject;
	}
	public String getMsg() {
		return msg;
	}
	public int getCode() {
		return code;
	}
	public Data getData() {
		return data;
	}
}
