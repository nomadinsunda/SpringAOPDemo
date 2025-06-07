package com.intheeast.aspectjsupport.declaringaspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intheeast.aspectjsupport.declaringaspect.aspect.NotVeryUsefulAspect;
import com.intheeast.aspectjsupport.declaringaspect.service.MyService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.intheeast.aspectjsupport.declaringaspect")
public class AppConfig {

//    @Bean
//    public NotVeryUsefulAspect notVeryUsefulAspect() {
//        return new NotVeryUsefulAspect();
//    }

    @Bean
    public MyService myService() {
        return new MyService();
    }
}