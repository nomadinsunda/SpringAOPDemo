package com.intheeast.aspectjsupport.aspectinstantiationmodels.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect("perthis(execution(* com.intheeast.aspectjsupport.aspectinstantiationmodels.service.*.*(..)))")
@Component
public class PerThisAspect {

	 public PerThisAspect() {
	     System.out.println(">>> [PerThisAspect] New aspect instance created");
	 }
	
	 @Before("execution(* com.intheeast.aspectjsupport.aspectinstantiationmodels.service.*.*(..))")
	 public void beforeServiceCall() {
	     System.out.println(">>> [PerThisAspect] Before service method call");
	 }
}
