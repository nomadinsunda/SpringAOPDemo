package com.intheeast.aspectjsupport.enablingaspectjsupport.basedsubclass;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectjsupport.enablingaspectjsupport.basedsubclass.config.AppConfig;
import com.intheeast.aspectjsupport.enablingaspectjsupport.basedsubclass.service.FooService;


public class Main {

	public static void main(String[] args) {
		AbstractAutowireCapableBeanFactory aacbf;
		AnnotationAwareAspectJAutoProxyCreator  AAJPC;
		
		ApplicationContext context = 
        		new AnnotationConfigApplicationContext(AppConfig.class);

		FooService fooService = context.getBean(FooService.class);
		
		System.out.println(AopUtils.isCglibProxy(fooService)); // → true
		System.out.println(AopUtils.isJdkDynamicProxy(fooService)); // → false

		
		fooService.helloFoo();
		
	}

}
