package com.intheeast.proxyingmechanisms.understandingaopproxies.refactoring.useaopcontextcurrentproxy;

import org.springframework.aop.framework.ProxyFactory;

import com.intheeast.proxyingmechanisms.understandingaopproxies.Pojo;
import com.intheeast.proxyingmechanisms.understandingaopproxies.RetryAdvice;

public class Main {
	
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory(new SimplePojo());
		factory.addInterface(Pojo.class);
		factory.addAdvice(new RetryAdvice());
		factory.setExposeProxy(true);

		Pojo pojo = (Pojo) factory.getProxy();
		// this is a method call on the proxy!
		pojo.foo();
	}

}
