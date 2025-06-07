package com.intheeast.aspectjsupport.declaringadvice.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.intheeast.aspectjsupport.declaringadvice.model.DefaultUsageTracked;
import com.intheeast.aspectjsupport.declaringadvice.model.UsageTracked;

@Aspect
@Component
public class UsageTrackingAspect {

    @DeclareParents(value = "com.intheeast.aspectj.declaringadvice.service.*+", defaultImpl = DefaultUsageTracked.class)
    public static UsageTracked mixin;

	// (..): 메서드의 파라미터 개수와 타입에 상관없이 일치합니다. 즉, 파라미터가 0개일 수도 있고, 여러 개일 수도 있습니다.
    @Before("execution(* com.intheeast.aspectj.declaringadvice.service.*.*(..)) && this(usageTracked)")
    public void trackUsage(UsageTracked usageTracked) {
        usageTracked.incrementUseCount();
        System.out.println("Usage count incremented: " + usageTracked.getUseCount());
    }
}