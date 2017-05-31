package com.sf.netmarket.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.netmarket.bizenum.ClientName;

public interface AuthService {
  void logout(HttpServletRequest request,HttpServletResponse response);
  void removeAuthentication(ClientName clientName, long authedUserId);
  void reloadAuth(String client, Long userId);
}
