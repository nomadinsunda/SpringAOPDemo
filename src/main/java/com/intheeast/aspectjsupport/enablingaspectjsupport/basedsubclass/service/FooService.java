package com.intheeast.aspectjsupport.enablingaspectjsupport.basedsubclass.service;

// cglib을 통해서 FooServie를 상속한 프록시 클래스의 인스턴스를 빈으로 IoC에 등록하고 있음
//@Component
public class FooService {
	// Autowired 를 사용
	//private Repository repo; 
	
	public FooService(/*Repository repo*/) {
		// 특정 DAO 또는 Repository 계층[데이터베이스 CRUD]을 사용: 디펜던시..
		// DAO : Data Access Object
		//this.repo = repo;
		System.out.println("FooService constructor");
	}
	
	public void helloFoo() {
		System.out.println("FooService.helloFoo Method");
		
	}

}
