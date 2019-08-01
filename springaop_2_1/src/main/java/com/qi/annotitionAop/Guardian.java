package com.qi.annotitionAop;/*
    name zhang;
    */

//切面类

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //代表当前类是一个切面类
public class Guardian {

    //切点规定的是通知的范围,
    @Pointcut("execution(* com.qi.annotitionAop.Monkey.stealPeaches(..))")
    public void foundMonkey(){ }

    @Before(value = "foundMonkey()")
    public void foundBefore(){
        System.out.println("悄悄的,猴子已经来来,可以抓他了...");
    }

}
