package com.sf.netmarket.service;

import com.sf.netmarket.bizenum.LoginType;
import com.sf.netmarket.viewbean.BindResult;
import com.sf.netmarket.viewbean.LoginResultInfo;


public interface IdentificationService {

  boolean validatePassword(long userId, String password);

  LoginResultInfo validateByDynamicCode(String validateKey, String code);

  BindResult bind(Long userId, String identification, LoginType identifyType);

  /**
   * 根据用户绑定手机或邮箱称获取用户id。
   * @param username
   * @return
   */
  Long getUserIdByIdentify(String telOrEmail);

}
