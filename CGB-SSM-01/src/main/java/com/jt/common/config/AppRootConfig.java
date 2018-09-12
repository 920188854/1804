package com.jt.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.jt.sys.controller.SysConfigController;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.service.SysConfigService;
import com.jt.sys.service.impl.SysConfigServiceImpl;

@Configuration
@PropertySource("classpath:configs.properties")
@ComponentScan("com.jt")
public class AppRootConfig {

	@Bean(value="dataSource",initMethod="init",destroyMethod="close")	//=>	<bean id="默认是方法名"
	public DruidDataSource newDruidDataSource(@Value("${jdbcDriver}")String driver, 
											  @Value("${jdbcUrl}")String url, 
											  @Value("${jdbcUser}")String user, 
											  @Value("${jdbcPassword}")String password) {
		DruidDataSource druid = new DruidDataSource();
		druid.setDriverClassName(driver);
		druid.setUrl(url);
		druid.setUsername(user);
		druid.setPassword(password);
		return druid;
	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean newSqlSessionFactoryBean(@Autowired DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		/* 关联数据源对象 */
		factoryBean.setDataSource(dataSource);
		/* 关联mapper映射文件 */
		Resource[] resource = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml");
		factoryBean.setMapperLocations(resource);
		return factoryBean;
	}
	@Bean
	public MapperScannerConfigurer newMapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("com.jt.**.dao");
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return msc;
	}
//	@Bean("sysConfigService")
//	public SysConfigServiceImpl newSysConfigServiceImpl() {
//		SysConfigServiceImpl sysConfigServiceImpl = new SysConfigServiceImpl();
//		return sysConfigServiceImpl;
//	}
//	@Bean("sysConfigController")
//	public SysConfigController newSysConfigController() {
//		SysConfigController controller = new SysConfigController();
//		return controller;
//	}
}
