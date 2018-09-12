package com.jt.common.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/** 替换	web.xml */
/**
 * **思考：
 * 1)此类何时被加载？	tomcat启动时
 * 2)加载的流程时怎样的？
 * 		启动时会会读取如下路径文件
 * 		(Maven Dependencies/spring-web-4.3.9.RELEASE.jar/META-INF/services/javax.servlet.ServletContainerInitializer)
 * 		获取文件中的定义类，并加载此类，然后加载修饰此类@HandlesTypes的注释中定义的类
 * 
 */
public class AppWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

	public AppWeb() {
		System.out.println("AbstractAnnotationConfigDispatcherServletInitializer");
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		registerServletFilter(servletContext, filter).addMappingForUrlPatterns(null, false, "/*");
	}
	
	/** service,dao */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses()");
		return new Class[]{AppRootConfig.class};
	}

	/** 加载spring-config.xml类 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()");
		return new Class[]{AppServletConfig.class};
	}

	/** 映射路径 url-pattern */
	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings()");
		return new String[]{"*.do"};
	}

	
}
