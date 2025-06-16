package com.intheeast.adviceapiinspring.advices;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class SimpleThrowsAdvice implements ThrowsAdvice {
	
//	public void afterThrowing(Exception ex) {
//        System.out.println("Exception thrown exception: " + ex.getMessage());
//    }

    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        System.out.println("Exception thrown in method: " + m.getName() + ", exception: " + ex.getMessage());
    }
}