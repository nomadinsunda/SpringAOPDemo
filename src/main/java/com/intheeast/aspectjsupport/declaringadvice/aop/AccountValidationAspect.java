package com.intheeast.aspectjsupport.declaringadvice.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.intheeast.aspectjsupport.declaringadvice.model.Account;

@Aspect
@Component
public class AccountValidationAspect {

    // 특정 포인트컷을 정의: Account 인스턴스를 첫 번째 아규먼트[args(account,..)]로 받는 메서드 실행
	// (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @Pointcut("execution(* com.intheeast.aspectj.declaringadvice.dao.*.*(..)) && args(account,..)")
    private void accountDataAccessOperation(Account account) {}

    // 해당 포인트컷에 매칭되는 메서드 실행 전에 검증 수행
    @Before("accountDataAccessOperation(account)")
    public void validateAccount(Account account) {
        // 간단한 검증 예제: 잔액이 음수인지 확인
        if (account.getBalance() < 0) {
            throw new IllegalArgumentException("Account balance cannot be negative");
        }
        System.out.println("Account validation passed for: " + account);
    }
}