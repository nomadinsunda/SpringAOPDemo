package com.intheeast.aspectjsupport.declaringadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {

    @Pointcut("within(com.intheeast.aspectjsupport.declaringadvice.service..*)")
    public void inDataAccessLayer() {}
}