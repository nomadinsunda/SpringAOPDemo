package com.intheeast.aspectjsupport.aspectinstantiationmodels.service;

public class MyServiceImpl implements MyService {
	private final String id;

	public MyServiceImpl(String id) {
		this.id = id;
	}

	@Override
	public void serve() {
		System.out.println("[MyService] Serving from " + id);
	}
}
