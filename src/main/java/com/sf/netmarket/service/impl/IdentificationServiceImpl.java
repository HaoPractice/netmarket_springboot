package com.sf.netmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.netmarket.bizenum.IdentifyType;
import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.mapper.CustomerMapper;

@Service
public class IdentificationServiceImpl {
  
  @Autowired
  CustomerMapper customerMapper;
  @Autowired
  AuthServiceImpl authServiceImpl;
  
  public LoginResult validatePassword(String username ,String encodedPassword){
    
    
    
    
    return LoginResult.SUCCESS;
  }
  
  public LoginResult validateDynamicCode(String username ,String code){
    
    
    
    
    return LoginResult.SUCCESS;
  }
  
  public boolean addIdentification(Long userId,String identification,IdentifyType identifyType){
    
    
    return true;
  }
  
}
