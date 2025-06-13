package com.intheeast.aspectjsupport.aspectinstantiationmodels;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intheeast.aspectjsupport.aspectinstantiationmodels.config.AppConfig;
import com.intheeast.aspectjsupport.aspectinstantiationmodels.service.MyService;

public class Main {
	
	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService svc1 = ctx.getBean("myService1", MyService.class);
        MyService svc2 = ctx.getBean("myService2", MyService.class);

        svc1.serve();
        svc1.serve();
        svc2.serve();
        svc2.serve();
        
        for (String beanName : ctx.getBeanDefinitionNames()) {
		    Object bean = ctx.getBean(beanName);
		    Class<?> beanClass = bean.getClass();

		    boolean isAopProxy = AopUtils.isAopProxy(bean);
		    boolean isCglib = AopUtils.isCglibProxy(bean);
		    boolean isJdk = AopUtils.isJdkDynamicProxy(bean);

		    System.out.printf("빈 이름: %-20s | 프록시: %-5s | 타입: %s%n",
		        beanName, isAopProxy ? "예" : "아니오", beanClass.getName());
		}

        ctx.close();
	}

}
