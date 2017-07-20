package com.sf.netmarket.service;

import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.viewbean.LoginResultInfo;


public interface AccountService {

  LoginResultInfo login(String username,String password);
}
