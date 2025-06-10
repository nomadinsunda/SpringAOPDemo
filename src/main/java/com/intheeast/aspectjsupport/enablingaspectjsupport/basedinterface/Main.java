package com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.confing.AppConfig;
import com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.service.*;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
        		new AnnotationConfigApplicationContext(AppConfig.class);

		/*
		 JDK 다이나믹 프록시는 인터페이스 기반으로만 프록시를 만듦
		 그래서 인터페이스 타입으로만 접근 가능
		 */
		FooService fooService = context.getBean(FooService.class);
		
		System.out.println(AopUtils.isCglibProxy(fooService)); // → true
		System.out.println(AopUtils.isJdkDynamicProxy(fooService)); // → false

		
		fooService.helloFoo();
		
	}

}
