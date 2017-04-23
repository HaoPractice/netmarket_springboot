package com.sf.netmarket.configs;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement  // 待学习
@Configuration
//@MapperScan(basePackages="${scanner.basePackage}",sqlSessionFactoryRef="${scanner.sqlSessionFactoryName}") // 在加载mybatis配置时，placeholder还没生效，不能用el表达式
@MapperScan(basePackages=MybatisConfig.SCANNER_BASE_PACKAGE,sqlSessionFactoryRef=MybatisConfig.BASE_SESSION_FACTORY_NAME)
public class MybatisConfig {
  
   
    private static final String TYPE_ALIASES_PACKAGE = "com.sf.netmarket.model";
    static final String SCANNER_BASE_PACKAGE = "com.sf.netmarket.mapper";
    static final String BASE_SESSION_FACTORY_NAME = "sqlSessionFactory";
//  @Autowired
//  private DataSource baseDatasource;
  /**
   * MyBatis基础配置
   *
   * @author liuzh
   * @since 2015-12-19 10:11
   */
  @Bean(name = BASE_SESSION_FACTORY_NAME)
  public SqlSessionFactory sqlSessionFactoryBean(@Autowired DataSource baseDatasource) {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(baseDatasource);
    bean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);

//    // 添加插件
//    bean.setPlugins(new Interceptor[] {...});

    // 添加XML目录
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    try {
      bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
      return bean.getObject();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  /**
   * 配置mapper文件的位置  交给注解：MapperScan
   * @return
   */
//  @Bean
//  // 这里不用static ,datasource 会为null
//  @ConfigurationProperties(prefix="scanner")
//  public MapperScannerConfigurer mapperScannerConfigurer(@Autowired MybatisMapperConfigBean mybatisMapperConfigBean) {
//    
//    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//    
////    mapperScannerConfigurer.setBasePackage("com.sf.netmarket.mapper");
////    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//    mapperScannerConfigurer.setBasePackage("${scanner.basePackage}"); //  无法使用 MybatisMapperConfigBean 注入.
//    mapperScannerConfigurer.setSqlSessionFactoryBeanName("${scanner.sqlSessionFactoryBeanName}");
//    return mapperScannerConfigurer;
//  }

  
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  public PlatformTransactionManager annotationDrivenTransactionManager(@Autowired DataSource baseDatasource) {
    return new DataSourceTransactionManager(baseDatasource);
  }
}
