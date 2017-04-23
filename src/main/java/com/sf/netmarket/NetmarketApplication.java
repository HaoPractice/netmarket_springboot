package com.sf.netmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource(value="${spring.placeholder-location}") //也可以在其他bean里设置，能全局读取 
public class NetmarketApplication {

  public static void main(String[] args) {
    SpringApplication.run(NetmarketApplication.class, args);
  }
  
}
