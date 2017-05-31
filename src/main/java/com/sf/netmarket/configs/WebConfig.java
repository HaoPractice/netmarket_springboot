package com.sf.netmarket.configs;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc 相关配置类
 * @author hao19
 *
 */
@Configuration
public class WebConfig  {
  private WebMvcConfigurerAdapter webMvcConfigurer = new WebMvcConfigurerAdapter() {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//      registry.addViewController("/cas").setViewName("/index"); // 这里就不转发到controller了，而是直接转发到template
      registry.addViewController("/404").setViewName("/404");
      registry.addViewController("/500").setViewName("/500");
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
      configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
    }
  };
  
  @Bean
  WebMvcConfigurerAdapter webMvcConfigurer(){
    return  webMvcConfigurer;
  }
  
  @Bean
  EmbeddedServletContainerCustomizer configErrPage(){
    return container -> {
      ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
      ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
      container.addErrorPages(errorPage404,errorPage500);
    };
  }
  
  
}
