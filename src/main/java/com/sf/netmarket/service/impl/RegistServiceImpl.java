package com.sf.netmarket.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.netmarket.bizenum.IdentifyType;
import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.mapper.CustomerMapper;
import com.sf.netmarket.service.AuthService;
import com.sf.netmarket.service.IdentificationService;
import com.sf.netmarket.viewbean.BindResult;
import com.sf.netmarket.viewbean.ValidateInfo;

@Service
public class IdentificationServiceImpl implements IdentificationService {
  
  @Autowired
  CustomerMapper customerMapper;
  @Autowired
  AuthService authServiceImpl;
  
  /* (non-Javadoc)
   * @see com.sf.netmarket.service.impl.IdentificationService#validatePassword(java.lang.String, java.lang.String)
   */
  @Override
  public ValidateInfo validatePassword(String username ,String encodedPassword){
    
    Long userId = 1L;
    String accessToken = UUID.randomUUID().toString();
    ValidateInfo validateInfo = new ValidateInfo(accessToken,userId.toString(),LoginResult.SUCCESS);
    return validateInfo;
  }
  
  /* (non-Javadoc)
   * @see com.sf.netmarket.service.impl.IdentificationService#validateByDynamicCode(java.lang.String, java.lang.String)
   */
  @Override
  public ValidateInfo validateByDynamicCode(String username ,String code){
    Long userId = 1L;
    String accessToken = UUID.randomUUID().toString();
    ValidateInfo validateInfo = new ValidateInfo(accessToken,userId.toString(),LoginResult.SUCCESS);
    return validateInfo;
  }
  
  /* (non-Javadoc)
   * @see com.sf.netmarket.service.impl.IdentificationService#bind(java.lang.Long, java.lang.String, com.sf.netmarket.bizenum.IdentifyType)
   */
  @Override
  public BindResult bind(Long userId,String identification,IdentifyType identifyType){
    return BindResult.SUCCESS;
  }
  
}
