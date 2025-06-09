package com.intheeast.aspectjsupport.enablingaspectjsupport.aopdemo;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectjsupport.enablingaspectjsupport.aopdemo.config.AppConfig;
import com.intheeast.aspectjsupport.enablingaspectjsupport.aopdemo.service.GreetingService;
import com.intheeast.aspectjsupport.enablingaspectjsupport.aopdemo.service.LoggingService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService = ctx.getBean(GreetingService.class);
        greetingService.sayHello(); // AOP 적용됨

        LoggingService loggingService = ctx.getBean(LoggingService.class);
        loggingService.logMessage(); // AOP 적용됨

        System.out.println("--- Proxy Types ---");
        System.out.println("GreetingService subclass proxy: " + AopUtils.isCglibProxy(greetingService)); 
		System.out.println("GreetingService interface proxy: " + AopUtils.isJdkDynamicProxy(greetingService));
        
		System.out.println("LoggingService subclass proxy: " + AopUtils.isCglibProxy(loggingService)); 
		System.out.println("LoggingService interface proxy: " + AopUtils.isJdkDynamicProxy(loggingService));
        
    }
}