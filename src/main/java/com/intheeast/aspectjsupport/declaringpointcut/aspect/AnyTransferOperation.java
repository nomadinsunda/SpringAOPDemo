package com.intheeast.aspectjsupport.declaringpointcut.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnyTransferOperation {
	
	// 특정 메서드 이름을 매칭하는 포인트컷
	@Pointcut("execution(* transfer(..))")
    private void anyTransferOperation() {}   
	
	// 어드바이스 정의
    // transfer 메서드가 실행되기 전에 메서드 이름, 전달된 아규먼트, 타겟 클래스의 정보를 로그로 출력합니다.
    @Before("anyTransferOperation()")
    public void logBeforeTransfer(JoinPoint joinPoint) {
        System.out.println("Logging before transfer operation");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Target class: " + joinPoint.getTarget().getClass().getName());
    }

}
