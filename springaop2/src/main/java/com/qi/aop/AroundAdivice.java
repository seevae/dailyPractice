package com.qi.aop;/*
    name zhang;
    */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdivice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕通知前面的方法开始执行-----------");
        Object o =  methodInvocation.proceed();
        System.out.println("环绕通知后面的方法开始执行***********");
        return null;
    }
}
