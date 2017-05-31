package com.sf.netmarket.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * org.springframework.context.support.AbstractApplicationContext.refresh()調用
 * invokeBeanFactoryPostProcessor时
 * 不能起到配置作用，因为加载placeholder的属性在配置scanner之前。
 * @author hao19
 *
 */
@ConfigurationProperties(prefix = "scanner")
@Configuration
public class MybatisMapperConfigBean {
  private String basePackage;
  private String sqlSessionFactoryBeanName;

  public String getBasePackage() {
    return basePackage;
  }

  public void setBasePackage(String basePackage) {
    this.basePackage = basePackage;
  }

  public String getSqlSessionFactoryName() {
    return sqlSessionFactoryBeanName;
  }

  public void setSqlSessionFactoryBeanName(String SqlSessionFactoryBeanName) {
    this.sqlSessionFactoryBeanName = SqlSessionFactoryBeanName;
  }

  @Override
  public String toString() {
    return "MybatisMapperConfigBean [basePackage=" + basePackage + ", sqlSessionFactoryBeanName="
        + sqlSessionFactoryBeanName + "]";
  }


}
