package com.intheeast.aspectjsupport.aspectinstantiationmodels.config;

import org.springframework.context.annotation.*;

import com.intheeast.aspectjsupport.aspectinstantiationmodels.service.MyService;
import com.intheeast.aspectjsupport.aspectinstantiationmodels.service.MyServiceImpl;

@Configuration
@ComponentScan({"com.intheeast.aspectinstantiationmodels"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

	 @Bean
	 public MyService myService1() {
	     return new MyServiceImpl("SVC1");
	 }
	
	 @Bean
	 public MyService myService2() {
	     return new MyServiceImpl("SVC2");
	 }
}
