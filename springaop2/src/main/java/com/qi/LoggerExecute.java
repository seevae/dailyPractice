package com.qi;/*
    name zhang;
    */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面
 *
 */

public class LoggerExecute implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        befor();
        methodInvocation.proceed();
        return null;
    }

    public void befor(){
        System.out.println("程序开始");
    }

}
