package com.intheeast.aspectjsupport.declaringadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {

    @Pointcut("within(com.intheeast.aspectj.declaringadvice.service..*)")
    public void inDataAccessLayer() {
        // 포인트컷 표현식
    }
}