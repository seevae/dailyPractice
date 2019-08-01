package com.qi.aop;/*
    name zhang;
    */

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdivce implements AfterReturningAdvice {

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("后置通知执行------------"+method.getName());
    }
}
