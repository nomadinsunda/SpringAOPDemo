package com.intheeast.proxyingmechanisms.understandingaopproxies.refactoring.injectselfreference;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.intheeast.proxyingmechanisms.understandingaopproxies.Pojo;
import com.intheeast.proxyingmechanisms.understandingaopproxies.RetryAdvice;
import com.intheeast.usingtheproxyfactorybeantocreateaopproxies.jbproperties.service.SimpleService;

@Configuration
public class AppConfig {

    @Bean
    public RetryAdvice retryAdvice() {
        return new RetryAdvice();
    }

    // 실제 객체 (프록시 대상)
    @Bean
    public SimplePojo simplePojo() {
        return new SimplePojo();
    }

    // 프록시 등록
    @Bean
    @Primary
    public Pojo pojo(SimplePojo target) {
        ProxyFactory factory = new ProxyFactory(target);
        factory.setInterfaces(Pojo.class);
        factory.addAdvice(retryAdvice());
        factory.setProxyTargetClass(false); // JDK 동적 프록시
        return (Pojo) factory.getProxy();
    }
}
