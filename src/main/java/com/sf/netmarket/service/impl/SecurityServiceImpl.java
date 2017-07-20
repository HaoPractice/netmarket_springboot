package com.sf.netmarket.service.impl;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sf.netmarket.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

  // private Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
  private ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);

  @Override
  public boolean validPassword(String encodedPwd, String rawPwd, String salt) {
    return shaPasswordEncoder.isPasswordValid(encodedPwd, rawPwd, salt);
  }

  @Override
  public String encodePassword(String rawPwd, String salt) {
    return shaPasswordEncoder.encodePassword(rawPwd, salt);
  }
}
