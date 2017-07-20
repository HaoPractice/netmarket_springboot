package com.sf.netmarket.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * spring mvc 相关配置类
 * @author hao19
 *
 */
//@Configuration
public class AutorizationConfig extends AuthorizationServerConfigurerAdapter {
  @Autowired
  private RedisConnectionFactory connectionFactory;
  @Autowired
  private TokenStore tokenStore;
  
  @Bean(name = "tokenStore")
  public TokenStore tokenStore(){
    return new RedisTokenStore(connectionFactory);
  }
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore);
    super.configure(endpoints);
  }

}
