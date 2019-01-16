package com.zhitar.spring_mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.zhitar.spring_mvc.service.*.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint point) {
        System.out.println("Invocation of method" + point.getSignature());
    }

    @Around("execution(* com.zhitar.spring_mvc.service.*.*(..))")
    public Object aroundServiceMethodExecution(ProceedingJoinPoint point) {
        long start = System.currentTimeMillis();
        try {
            Object proceed = point.proceed();
            long end = System.currentTimeMillis();
            System.out.println("Execution of method " + point.getSignature() + " took " + (end - start) + " msec.");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
