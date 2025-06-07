package com.intheeast.aspectjsupport.declaringpointcut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intheeast.aspectjsupport.declaringpointcut.aspect.LoggingAspect;
import com.intheeast.aspectjsupport.declaringpointcut.service.MyService;
import com.intheeast.aspectjsupport.declaringpointcut.service.MyServiceImpl;
import com.intheeast.aspectjsupport.declaringpointcut.service.SpecialService;
import com.intheeast.aspectjsupport.declaringpointcut.service.TransferService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.intheeast.aspectjsupport.declaringpointcut")
public class AppConfig {

//    @Bean
//    public LoggingAspect loggingAspect() {
//        return new LoggingAspect();
//    }

//    @Bean
//    public TransferService transferService() {
//        return new TransferService();
//    }
    
//    @Bean
//    public SpecialService specialService() {
//        return new SpecialService();
//    }
    
    @Bean(name = "myServiceBean") // 👈 이름에 주목
    public MyService myService() {
        return new MyServiceImpl();
    }
}