package com.intheeast.pointcutapi.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import com.intheeast.pointcutapi.service.CustomAnnotation;

public class CustomPointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
    	// startsWiths는 해당 패키지 내의 모든 클래스에 대해 true를 리턴함
        return clazz -> clazz.getName().startsWith("com.intheeast.pointcutapi.service");
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
        	// Spring AOP는 프록시 생성 시점에 matches(Method, Class)만 사용해서 Advisor 적용 여부를 미리 결정
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                // 특정 어노테이션이 있는 메서드와 메서드 이름이 "differentMethod"인 경우 매칭
                return method.isAnnotationPresent(CustomAnnotation.class)
                        || "differentMethod".equals(method.getName());
            }

            @Override
            public boolean isRuntime() {
//                return true;
            	return false; 
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                // 아규먼트가 String 타입인 경우 매칭
                if (args.length > 0 && args[0] instanceof String) {
                    return true;
                }
                return false;
            }
        };
    }
}
