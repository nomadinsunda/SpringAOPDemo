package com.intheeast.proxyingmechanisms.understandingaopproxies.refactoring.useaopcontextcurrentproxy;

import org.springframework.aop.framework.AopContext;

import com.intheeast.proxyingmechanisms.understandingaopproxies.Pojo;

public class SimplePojo implements Pojo {

	public void foo() {
		System.out.println("[SimplePojo] foo() 호출됨");
		// This works, but it should be avoided if possible.
		((Pojo) AopContext.currentProxy()).bar();
	}

	public void bar() {
		System.out.println("[SimplePojo] bar() 호출됨");
	}
}