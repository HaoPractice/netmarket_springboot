package com.sf.netmarket.service;

import com.sf.netmarket.bizenum.IdentifyType;
import com.sf.netmarket.viewbean.BindResult;
import com.sf.netmarket.viewbean.ValidateInfo;


public interface IdentificationService {

  ValidateInfo validatePassword(String username, String encodedPassword);

  ValidateInfo validateByDynamicCode(String username, String code);

  BindResult bind(Long userId, String identification, IdentifyType identifyType);

}
