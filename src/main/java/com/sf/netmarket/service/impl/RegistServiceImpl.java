package com.sf.netmarket.service.impl;

import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sf.netmarket.bizenum.LoginType;
import com.sf.netmarket.mapper.UserInfoMapper;
import com.sf.netmarket.mapper.UserSaltMapper;
import com.sf.netmarket.model.UserInfo;
import com.sf.netmarket.model.UserSalt;
import com.sf.netmarket.service.IdentificationService;
import com.sf.netmarket.service.RegistService;
import com.sf.netmarket.service.SecurityService;
import com.sf.netmarket.service.model.RegistResult;
import com.sf.netmarket.service.model.RegistResultEnum;
import com.sf.netmarket.viewbean.RegistInfo;

@Service
public class RegistServiceImpl implements RegistService {

  @Autowired
  private UserInfoMapper userInfoMapper;
  @Autowired
  private IdentificationService identificationService;
  @Autowired
  private SecurityService securityService;
  @Autowired
  private UserSaltMapper userSaltMapper;

  @Override
  @Transactional
  public RegistResult doRegist(RegistInfo registInfo) {
    RegistResult error = validateRegistInfo(registInfo);
    if (error.result() != RegistResultEnum.SUCCESS) {
      return error;
    }
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername(registInfo.getUsername());
    String password = registInfo.getPassword();
    
    String salt = UUID.randomUUID().toString();
    String encodePassword = securityService.encodePassword(password, salt);
    userInfo.setPassword(encodePassword);
    userInfoMapper.insert(userInfo);
    String bindMail = registInfo.getBindMail();
    String bindTel = registInfo.getBindTel();

    Long userId = userInfo.getUserId();
    saveSalt(salt, userId);
    bind(bindMail, bindTel, userId);
    
    return RegistResult.create(RegistResultEnum.SUCCESS);
  }

  private void bind(String bindMail, String bindTel, Long userId) {
    if (StringUtils.isNotBlank(bindTel)) {
      identificationService.bind(userId, bindTel, LoginType.TEL);
    } else if (StringUtils.isNotBlank(bindMail)) {
      identificationService.bind(userId, bindMail, LoginType.EMAIL);
    } else {
      throw new RuntimeException(RegistResultEnum.BLANK_ACCOUNT.toString());
    }
  }

  private void saveSalt(String salt, Long userId) {
    UserSalt userSalt = new UserSalt();
    userSalt.setSalt(salt);
    userSalt.setUserId(userId);
    userSaltMapper.insert(userSalt);
  }

  private @Nullable RegistResult validateRegistInfo(RegistInfo registInfo) {
    String email = registInfo.getBindMail();
    String bindTel = registInfo.getBindTel();
    if (StringUtils.isBlank(email) && StringUtils.isBlank(bindTel)) {
      return RegistResult.create(RegistResultEnum.BLANK_ACCOUNT);
    }
    Long userIdByTelOrEmail = identificationService.getUserIdByIdentify(email);
    if (userIdByTelOrEmail != null) {
      return RegistResult.create(RegistResultEnum.EXISTED);
    }
    userIdByTelOrEmail = identificationService.getUserIdByIdentify(bindTel);
    if (userIdByTelOrEmail != null) {
      return RegistResult.create(RegistResultEnum.EXISTED);
    }
    return RegistResult.create(RegistResultEnum.SUCCESS);
  }


}
