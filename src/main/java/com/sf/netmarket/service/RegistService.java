package com.sf.netmarket.service;

import com.sf.netmarket.service.model.RegistResult;
import com.sf.netmarket.viewbean.RegistInfo;

public interface RegistService {

  /**
   * 注册接口
   * 
   * @param registInfo 用户名，密码为必填。邮箱和手机至少填写一个。
   * @return 注册状态
   */
  RegistResult doRegist(RegistInfo registInfo);

}
