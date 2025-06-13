package com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	// 다음 Pointcut expression은 AspectJ에서 채용함.
	// inline Pointcut
    @Before("execution(* com.intheeast.aspectjsupport.enablingaspectjsupport.basedinterface.service.FooService+.*(..))")
    public void advice() {
        System.out.println("MyAspect advice");
    }
}