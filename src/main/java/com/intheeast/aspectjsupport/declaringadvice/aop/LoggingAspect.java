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

	// (..): 메서드의 파라미터 개수와 타입에 상관없이 일치. 
	// 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있음.
    @Before("execution(* com.intheeast.aspectjsupport.declaringadvice.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
    	String str = joinPoint.getClass().getName();
    	
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }
    
    // After Returning Advice
    // (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 
    // 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    // 타겟 메서드의 리턴 값을 확인할 수 있음.
    @AfterReturning(
        pointcut = "execution(* com.intheeast.aspectjsupport.declaringadvice.service.*.*(..))",
        returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
    	//Class clazzz = void.class; // 특정 메서드가 리턴할 값이 없을 경우
//    	String clazzName = joinPoint.getClass().getName();
//    	System.out.println("logAfterReturning Advice : Target Class" + clazzName);
        System.out.println("Method returned: " + 
        		joinPoint.getSignature().getName() + " with result = " + result);
    }

    // After Throwing Advice
    // (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    // 타겟 클래스 메서드에서 예외가 발생하면,
    // 이 메서드가 이 예외를 처리하지 않고
    // 'throws' 하면 이 어드바이스가 적용이 됨.
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