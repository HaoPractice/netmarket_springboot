package com.sf.netmarket.service.impl;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sf.netmarket.bizenum.ClientName;
import com.sf.netmarket.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
  @Override
  public void reloadAuth(String client, Long userId) {

  }

  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    // 删除所有cookie
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
  }

  @Override
  public void removeAuthentication(ClientName client, long userId) {
    // TODO Auto-generated method stub

  }

  @Override
  public String getAuthCode(long userId, ClientName clientName) {
    // TODO Auto-generated method stub
    return UUID.randomUUID().toString();
  }
}
