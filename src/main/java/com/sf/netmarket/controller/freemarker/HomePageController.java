package com.sf.netmarket.controller.freemarker;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sf.netmarket.configs.MybatisConfig;
import com.sf.netmarket.controller.AbstractSecurityController;
import com.sf.netmarket.mapper.UserInfoMapper;
import com.sf.netmarket.model.UserInfo;
import com.sf.netmarket.viewbean.UserInfoViewBean;

@Controller
@RequestMapping("")
public class HomePageController extends AbstractSecurityController {

	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	MybatisConfig mybatisConfig;

	@RequestMapping({ "index", "" })
	public ModelAndView getUserInfoByName() {
		ModelAndView modelAndView = new ModelAndView("index");
		ServletRequest servletRequest = servletRequest();
		if (servletRequest instanceof HttpServletRequest) {
			String userAddr = ((HttpServletRequest) servletRequest).getRemoteAddr();
			userAddr = getRealIp(userAddr);
			modelAndView.addObject("myip", userAddr);
			String serverAddr = ((HttpServletRequest) servletRequest).getLocalAddr();
			serverAddr = getRealIp(serverAddr);
			modelAndView.addObject("hostIp", serverAddr);
		}
		Long authedUserId = getUserId();
		boolean isLoggedIn = authedUserId != null;
		if (isLoggedIn) {
			UserInfo customer = getUserInfoByUserId(authedUserId);
			modelAndView.addObject("user", new UserInfoViewBean(customer.getUsername(), customer.getUserId().toString()));
		}
		return modelAndView;
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

	private UserInfo getUserInfoByUserId(Long authedUserId) {
		com.sf.netmarket.model.UserInfo customer = userInfoMapper.selectById(authedUserId);
		return customer;
	}

}
