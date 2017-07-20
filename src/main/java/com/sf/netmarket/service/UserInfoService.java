package com.sf.netmarket.service;

import com.sf.netmarket.model.UserInfo;

public interface UserInfoService {

  /**
   * 根据用户id查找用户信息
   * 
   * @param id
   * @return
   */
	UserInfo getUserById(long id);

}
