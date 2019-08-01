package com.qi.aop;/*
    name zhang;
    */

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

//前置通知类  ----> 就是一个前置的切面
public class BeforAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知-------..."+method);
    }
}
