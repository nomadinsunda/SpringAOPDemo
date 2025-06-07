package com.intheeast.aspectj.declaringpointcut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intheeast.aspectj.declaringpointcut.aspect.LoggingAspect;
import com.intheeast.aspectj.declaringpointcut.service.SpecialService;
import com.intheeast.aspectj.declaringpointcut.service.TransferService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.intheeast.aspectj.declaringpointcut")
public class AppConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public TransferService transferService() {
        return new TransferService();
    }
    
    @Bean
    public SpecialService specialService() {
        return new SpecialService();
    }
}