package com.intheeast.aspectjsupport.declaringaspect.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotVeryUsefulAspect {

    @Before("execution(* com.intheeast.aspectj.declaringaspect.service.MyService.*(..))")
    public void beforeMethod() {
        System.out.println("Aspect is triggered before method execution");
    }
}