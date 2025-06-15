package com.intheeast.proxyingmechanisms.understandingaopproxies;

import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {
        // 타겟 객체
        SimplePojo target = new SimplePojo();

        // 프록시 팩토리 생성
        ProxyFactory factory = new ProxyFactory(target);
        factory.addInterface(Pojo.class); // 인터페이스 기반 프록시
        factory.addAdvice(new RetryAdvice());

        // 프록시 생성
        Pojo proxy = (Pojo) factory.getProxy();

        System.out.println("==== 프록시를 통한 foo() 호출 시작 ====");
        proxy.foo(); // → foo는 Advice 적용 X (this.bar()는 내부 직접 호출이라서)
        System.out.println("==== 직접 bar() 호출 ====");
        proxy.bar(); // → Advice 적용됨
    }
}
