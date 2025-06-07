package com.intheeast.aspectjsupport.declaringadvice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    @Around("execution(java.util.List<com.intheeast.aspectj.declaringadvice.model.Account> " +
            "com.intheeast.aspectj.declaringadvice.service.AccountService.find*(..)) && " +
            "com.intheeast.aspectj.declaringadvice.aspect.CommonPointcuts.inDataAccessLayer() && " +
            "args(accountHolderNamePattern)")
    public Object preProcessQueryPattern(ProceedingJoinPoint pjp, String accountHolderNamePattern) throws Throwable {
        System.out.println("AccountAspect:preProcessQueryPattern:Calss: " + pjp.getTarget().getClass().getName());
        System.out.println("AccountAspect:preProcessQueryPattern:Method: " + pjp.getSignature().getName());
        // 파라미터를 수정하는 로직
        String newPattern = preProcess(accountHolderNamePattern);
        System.out.println("AccountAspect:preProcessQueryPattern:Modified pattern: " + newPattern);

        // 수정된 파라미터를 사용하여 메서드를 호출
        return pjp.proceed(new Object[]{newPattern});
    }

    private String preProcess(String pattern) {
        // 파라미터 수정 로직 (예: 패턴을 모두 대문자로 변환)
        return pattern.toUpperCase();
    }
}