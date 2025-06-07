package com.intheeast.aspectj.declaringadvice.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

	// (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @Before("execution(* com.intheeast.aspectj.declaringadvice.service.*.*(..))")
    public void checkSecurity() {
        // 보안 검사 로직
        System.out.println("Security check completed.");
    }
}