package com.qi.aop;/*
    name zhang;
    */

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ThrowsAdbice01 implements ThrowsAdvice {
    public void afterThrowing(Method m, Object[] os,Object target,Exception e){
        System.out.println("异常通知"+e.getMessage());
    }
}
