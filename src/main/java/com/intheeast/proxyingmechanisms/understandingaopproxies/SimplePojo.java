package com.intheeast.proxyingmechanisms.understandingaopproxies;

public class SimplePojo implements Pojo {
	
//	private String hello = "Hello";
//	
//	public SimplePojo() {
//		
//	}

    @Override
    public void foo() {
        System.out.println("[SimplePojo] foo() 호출됨");
        // 다음 bar 메서드 호출은 프록시가 아닌 this.bar() 이므로, AOP 적용이 안 됨!
        this.bar();
    }

    @Override
    public void bar() {
        System.out.println("[SimplePojo] bar() 호출됨 (Advice 적용 대상)");
    }
}
