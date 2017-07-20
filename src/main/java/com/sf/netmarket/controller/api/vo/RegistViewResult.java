package com.sf.netmarket.controller.api.vo;

import com.sf.netmarket.service.model.RegistResultEnum;

public enum RegistViewResult implements ViewResult{
	BLANK_NAME(100001,"用户名不能为空",RegistResultEnum.BLANK_NAME), // 默认不会出现这种情况。
	BLANK_PWD(100002,"密码不能为空",RegistResultEnum.BLANK_PWD),
	BLANK_ACCOUNT(100003,"账号（邮箱或手机）不能为空",RegistResultEnum.BLANK_ACCOUNT),
	DUPLICATE(100004,"邮箱重复了",RegistResultEnum.EXISTED),
	SENSITIVE(100005,"用户名包含敏感词",RegistResultEnum.SENSITIVE),
	SUCCESS(0,"成功",RegistResultEnum.SUCCESS),
	;
	private String msg;
	private int code;
	private RegistResultEnum registResultEnum;
	public static ViewResult of(RegistResultEnum registResultEnum) {
	  for (RegistViewResult registViewResult: values()) {
        if (registViewResult.registResultEnum == registResultEnum) {
          return registViewResult;
        }
      }
	  return SUCCESS;
    }
	RegistViewResult(int code,String msg,RegistResultEnum registResultEnum){
		this.code = code;
		this.msg = msg;
		this.registResultEnum = registResultEnum;
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
