package com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class HelloService {
	
	private FooService fooService;
	
	//@Autowired
	public HelloService(FooService fooService) {
		this.fooService = fooService;
	}

	public FooService getFooService() {
		return fooService;
	}

	public void setFooService(FooService fooService) {
		this.fooService = fooService;
	}
	
	

}
