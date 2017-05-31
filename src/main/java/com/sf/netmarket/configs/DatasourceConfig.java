package com.sf.netmarket.configs;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 待学习
@Configuration
public class DatasourceConfig {

  /**
   * baseDatasource配置
   *
   * 在 org.springframework.context.support.AbstractApplicationContext.refresh()
   * 里，调用org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(ConfigurableListableBeanFactory)
   * 时创建
   * 
   * @author hao
   * @since 2017年4月19日
   */
  @Bean("baseDatasource")
  @ConfigurationProperties(prefix = "spring.datasource.base")
  public DataSource baseDatasource() {
    DataSource build = DataSourceBuilder.create().build();
    return build;
  }
}
