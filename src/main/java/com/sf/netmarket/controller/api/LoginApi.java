package com.sf.netmarket.controller.api;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.netmarket.bizenum.LoginResult;
import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.controller.api.vo.CommonViewResult;
import com.sf.netmarket.service.AccountService;
import com.sf.netmarket.viewbean.LoginResultInfo;
import com.sf.netmarket.viewbean.ViewResultBean;

@RestController
@RequestMapping("/api/login")
public class LoginApi extends AbstractSecurityController {

  private static final String ACCOUNT_LOGIN_LOG_CACHE_NAME = "account:login:log:";
  @Autowired
  private RedisConnectionFactory redisConnectionFactory;
  @Autowired
  private AccountService accountService;

  /**
   * 
   * @param identificationString 手机或邮箱
   * @param password
   * @return
   */
  @PostMapping
  public ViewResultBean<LoginResultInfo> login(@RequestParam("loginAccount") String loginAccount,
      @RequestParam(value = "pwd") String password) {

    logUserLogInfo(loginAccount);

    HttpServletResponse servletResponse = servletResponse();
    if (servletResponse == null) {
      logger.error("获取servletRequest失败");
      return ViewResultBean.of(CommonViewResult.FAILED);
    }
    LoginResultInfo validateInfo = accountService.login(loginAccount, password);
    if (validateInfo.getLoginResult() == LoginResult.SUCCESS) {
      Cookie cookie = new Cookie("access_token", validateInfo.getAccessToken());
      cookie.setPath("/");
      servletResponse.addCookie(cookie);
      return ViewResultBean.of(CommonViewResult.SUCCESSED, validateInfo);
    }
    return ViewResultBean.of(CommonViewResult.FAILED, validateInfo);
  }

  private void logUserLogInfo(String loginAccount) {
    ServletRequest servletRequest = servletRequest();
    String userAddr = ((HttpServletRequest) servletRequest).getRemoteAddr();
    String loginIp = getRealIp(userAddr);
    RedisConnection connection = connection();
    try {
      connection.lPush((ACCOUNT_LOGIN_LOG_CACHE_NAME + loginAccount).getBytes(),
          loginIp.getBytes());
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (Exception e) {
          logger.error("", e);
        }
      }
    }
  }

  public RedisConnection connection() {
    RedisConnection connection = redisConnectionFactory.getConnection();
    return connection;
  }

  private String getRealIp(String ip) {
    if (ip.equals("0:0:0:0:0:0:0:1")) {
      try {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
          NetworkInterface networkInterface = networkInterfaces.nextElement();
          Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
          while (inetAddresses.hasMoreElements()) {
            InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
            if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()
                && inetAddress.isSiteLocalAddress()) {
              return inetAddress.getHostAddress().toString();
            }
          }
        }
        ip = new String(InetAddress.getLocalHost().getHostAddress());
      } catch (UnknownHostException | SocketException e) {
        logger.error("无法获取ip", e);
      }
    }
    return ip;
  }
}
