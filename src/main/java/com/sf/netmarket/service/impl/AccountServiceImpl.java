package com.sf.netmarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.netmarket.bizenum.ClientEnum;
import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.service.AccountService;
import com.sf.netmarket.service.AuthService;
import com.sf.netmarket.service.IdentificationService;
import com.sf.netmarket.viewbean.LoginResultInfo;

@Service
public class AccountServiceImpl implements AccountService{

  @Autowired
  private AuthService authService; 
  @Autowired
  private IdentificationService identificationService;
  
  @Override
  public LoginResultInfo login(String username, String password) {
    Long userId = identificationService.getUserIdByIdentify(username);
    if (userId == null) {
      return LoginResultInfo.err(LoginResult.NOT_EXIST);
    }
    
    if (identificationService.validatePassword(userId, password)) {
      String authCode = authService.getAuthCode(userId, ClientEnum.WEB_PC);
      return LoginResultInfo.success(authCode, userId, LoginResult.SUCCESS);
    }
    return LoginResultInfo.err(LoginResult.ERROR_PASSWORD);
  }

}
