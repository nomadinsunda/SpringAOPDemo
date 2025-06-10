package com.intheeast.aspectjsupport.enablingaspectjsupport.basedsubclass.service;

// cglib을 통해서 FooServie를 상속한 프록시 클래스의 인스턴스를 빈으로 IoC에 등록하고 있음
public class FooService {
	
	public FooService() {
		System.out.println("FooService constructor");
	}
	
	public void helloFoo() {
		System.out.println("FooService.helloFoo Method");
		
	}

}
