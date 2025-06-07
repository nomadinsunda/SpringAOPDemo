package com.intheeast.aspectjsupport.declaringadvice.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @Before("execution(* com.intheeast.aspectjsupport.declaringadvice.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }
    
    // After Returning Advice
    // (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @AfterReturning(
        pointcut = "execution(* com.intheeast.aspectjsupport.declaringadvice.service.*.*(..))",
        returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + 
        		joinPoint.getSignature().getName() + " with result = " + result);
    }

    // After Throwing Advice
    // (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @AfterThrowing(
        pointcut = "execution(* com.intheeast.aspectjsupport.declaringadvice.service.*.*(..))",
        throwing = "error"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("Method threw exception: " + joinPoint.getSignature().getName() + " with error = " + error);
    }

    // After (Finally) Advice
    // (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @After("execution(* com.intheeast.aspectjsupport.declaringadvice.service.*.*(..))")
    public void logAfterFinally(JoinPoint joinPoint) {
        System.out.println("Method finished: " + joinPoint.getSignature().getName());
    }

    // Additional method within the same aspect
    public void helperMethod() {
        // This method can be used internally within this aspect
        System.out.println("Helper method invoked.");
    }
}