package com.intheeast.aspectjsupport.declaringadvice.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.intheeast.aspectjsupport.declaringadvice.aop.ExecutionCountingAspect;
import com.intheeast.aspectjsupport.declaringadvice.aop.SampleAspect;
import com.intheeast.aspectjsupport.declaringadvice.aop.TimingAspect;
import com.intheeast.aspectjsupport.declaringadvice.model.MyType;
import com.intheeast.aspectjsupport.declaringadvice.service.Sample;
import com.intheeast.aspectjsupport.declaringadvice.service.SampleService;

@Configuration
@ComponentScan(basePackages = "com.intheeast.aspectjsupport.declaringadvice")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
	
    @Bean
    public ExecutionCountingAspect executionCountingAspect() {
        return new ExecutionCountingAspect();
    }

    @Bean
    public TimingAspect timingAspect() {
        return new TimingAspect();
    }

}