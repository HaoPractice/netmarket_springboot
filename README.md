# netmarket_springboot

##项目简介
 工作近三年，积累了点spring ，mybatis，redis的经验，想着写点什么练练手。于是便开始了这个项目。如项目名所示，该项目为一个使用springboot实现的网上商城。

##### 计划实现的功能：
---------------------
- 用户登录模块，支持手机、邮箱、微信、QQ登陆。
- 支付模块，支付宝，微信支付
- 增加、删除定时任务
- 权限模块。指定用户有指定时间的权限。
- 记录模块，用户每次访问的ip，访问的uri
- 库存管理，货品上架,下架。
- 秒杀

##### spring boot + mybatis的练手项目
---------------------

- 后台框架使用：springboot+mybatis
- 前端框架：amazeui-2.7.2
- 安全框架：spring security + redis(保存用户登录数据)
- 缓存：redis
- 访问记录,出错处理：spring aop
- sso单点登录
- 定时任务
- 爬虫
- 前端：freemarker + bootstrap + materializecss



遇到的困难点：
1. 整合springboot和mybatis，关于mapperScanner的配置加载时机，由于加载时间早，获取不到placeholder中的属性，因此只能写死。
	* http://www.mybatis.org/spring/apidocs/reference/org/mybatis/spring/mapper/MapperScannerConfigurer.html
2. 整合springboot和freemarker


## 配置：
* 页面映射：不需要加载数据的，单纯的模板映射，在WebConfig中配置。
* 配置controller的异常处理：使用@ControllerAdvice注解，实践类：com.sf.netmarket.controller.advice.OnExceptionControllerAdvice
* 配置指定类的访问记录，使用spring的切面实现：使用Aspect注解，实践类：com.sf.netmarket.aspect.LogAspect
* 配置contextPath属性在freemarker中的变量名称：在application.yml中配置属性：request-context-attribute: rc
* 配置数据源，事务：
	* DatasourceConfig.java
	* MybatisConfig.java
* SecurityConfig中配置安全策略，关闭了csrf：..csrf().disable();
