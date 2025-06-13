package com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.confing.AppConfig;
import com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.service.*;


public class Main {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory dlbf;
		
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
		
		for (String beanName : context.getBeanDefinitionNames()) {
		    Object bean = context.getBean(beanName);
		    Class<?> beanClass = bean.getClass();

		    // Check whether the given object is a JDK dynamic proxy or a CGLIB proxy.
		    //boolean isAopProxy = AopUtils.isAopProxy(bean);
		    boolean isCglib = AopUtils.isCglibProxy(bean);
		    boolean isJdk = AopUtils.isJdkDynamicProxy(bean);

		    System.out.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		    System.out.printf("빈 이름: %-20s \n"
		    		+ " cglib : %-5s \n" 
		    		+ " dynamic : %-5s \n"
		    		+ " 타입: %s%n ",
		    		beanName, 
		    		isCglib ? "예" : "아니오", 
		    		isJdk ? "예" : "아니오", 
		    		beanClass.getName());
		    System.out.printf("-----------------------------------------------------------------\n");
		}
	}

}
