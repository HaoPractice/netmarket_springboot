package com.sf.netmarket.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.bizenum.LoginType;
import com.sf.netmarket.mapper.UserIdentificationMapper;
import com.sf.netmarket.mapper.UserInfoMapper;
import com.sf.netmarket.mapper.UserSaltMapper;
import com.sf.netmarket.model.UserIdentification;
import com.sf.netmarket.model.UserIdentificationExample;
import com.sf.netmarket.model.UserInfo;
import com.sf.netmarket.model.UserSalt;
import com.sf.netmarket.model.UserSaltExample;
import com.sf.netmarket.service.AuthService;
import com.sf.netmarket.service.IdentificationService;
import com.sf.netmarket.service.SecurityService;
import com.sf.netmarket.viewbean.BindResult;
import com.sf.netmarket.viewbean.LoginResultInfo;

@Service
public class IdentificationServiceImpl implements IdentificationService {

  @Autowired
  private UserInfoMapper userInfoMapper;
  @Autowired
  private UserSaltMapper userSaltMapper;
  @Autowired
  private UserIdentificationMapper userIdentificationMapper;
  @Autowired
  private SecurityService securityService;

  @Override
  public boolean validatePassword(long userId, String unEncodedPassword) {
    UserInfo userInfo = userInfoMapper.selectById(userId);
    if (userInfo == null) {
      return false;
    }
    String password = userInfo.getPassword();

    return securityService.validPassword(password, unEncodedPassword, getSalt(userId));
  }

  private String getSalt(long userId) {
    UserSaltExample userIdCondition = new UserSaltExample();
    userIdCondition.createCriteria().andUserIdEqualTo(userId);
    UserSalt userSalt = userSaltMapper.selectByPrimaryKey(userId);
    if (userSalt == null) {
      return null;
    }
    return userSalt.getSalt();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.sf.netmarket.service.impl.IdentificationService#validateByDynamicCode(java.lang.String,
   * java.lang.String)
   */
  @Override
  public LoginResultInfo validateByDynamicCode(String validateKey, String code) {
    Long userId = 1L;
    String accessToken = UUID.randomUUID().toString();
    LoginResultInfo validateInfo = new LoginResultInfo(accessToken, userId, LoginResult.SUCCESS);
    return validateInfo;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sf.netmarket.service.impl.IdentificationService#bind(java.lang.Long, java.lang.String,
   * com.sf.netmarket.bizenum.IdentifyType)
   */
  @Override
  public BindResult bind(Long userId, String identification, LoginType identifyType) {

    UserIdentification userIdentification = new UserIdentification();
    userIdentification.setBinded(true);
    userIdentification.setUserId(userId);
    userIdentification.setBindTime(new Date());
    userIdentification.setIdentify(identification);
    userIdentification.setLoginType(identifyType.toString());
    userIdentificationMapper.insert(userIdentification);
    return BindResult.SUCCESS;
  }

  @Override
  public Long getUserIdByIdentify(String telOrEmail) {
    if (telOrEmail == null) {
      return null;
    }
    UserIdentificationExample example = new UserIdentificationExample();
    example.createCriteria().andIdentifyEqualTo(telOrEmail).andBindedEqualTo(true);
    List<UserIdentification> selectByExample = userIdentificationMapper.selectByExample(example);
    if (selectByExample.isEmpty()) {
      return null;
    }
    return selectByExample.get(0).getUserId();
  }

  public static void main(String[] args) {
    PlaintextPasswordEncoder PlaintextPasswordEncoder = new PlaintextPasswordEncoder();
    String encodePassword = PlaintextPasswordEncoder.encodePassword("aaaaaaa", "cc");
    System.out.println(encodePassword);
  }
}
