package com.sf.netmarket.service;

/**
 * 安全信息相关类。加密密码。
 * @author hao19
 *
 */
public interface SecurityService {
  boolean validPassword(String encodedPwd,String rawPwd,String salt);
  String encodePassword(String rawPwd,String salt);
}
