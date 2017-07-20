package com.sf.netmarket.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * spring mvc 相关配置类
 * @author hao19
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  private static final String ANONYMOUS_USER = "ANONYMOUS_USER";
  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
          .antMatchers("/*").permitAll()
          .and()
      .formLogin()
          .loginPage("/login")
          .permitAll()
          .and()
      .logout()
          .permitAll().and()
          // 关闭csrf
          .csrf().disable();
        
  }

}
