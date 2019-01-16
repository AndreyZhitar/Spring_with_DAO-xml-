package com.zhitar.spring_mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {

    public void beforeServiceMethodInvocation(JoinPoint point) {
        System.out.println("Invocation of method" + point.getSignature());
    }

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
