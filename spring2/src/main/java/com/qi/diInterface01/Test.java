package com.qi.diInterface01;/*
    name zhang;
    */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用接口的时候
 * 注册的还是实现接口的类
 * 但是在使用的时候可以向上转型为其对应的接口
 */
public class Test {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"bean03.xml"});
        ChangetoLowerCase case1 = (ChangetoLowerCase) applicationContext.getBean("changetoLowerCase");

        System.out.println(case1.change(case1.getStr()));

        //使用接口的方式
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext(new String[]{"bean03.xml"});
        ChangeLetter case2 = (ChangeLetter) applicationContext2.getBean("changetoUpCase");
        System.out.println(case2.change("qqqqqqqqq"));

    }
}
