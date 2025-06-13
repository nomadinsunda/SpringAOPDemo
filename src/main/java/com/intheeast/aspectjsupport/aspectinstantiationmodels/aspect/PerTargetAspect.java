package com.intheeast.aspectjsupport.aspectinstantiationmodels.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect("pertarget(execution(* com.intheeast.aspectjsupport.aspectinstantiationmodels.service.MyService.*(..)))")
@Component
public class PerTargetAspect {

	 public PerTargetAspect() {
	     System.out.println(">>> [PerTargetAspect] New aspect instance created");
	 }
	
	 @Before("execution(* com.intheeast.aspectjsupport.aspectinstantiationmodels.service.MyService.*(..))")
	 public void beforeServiceCall() {
	     System.out.println(">>> [PerTargetAspect] Before service method call");
	 }
}
