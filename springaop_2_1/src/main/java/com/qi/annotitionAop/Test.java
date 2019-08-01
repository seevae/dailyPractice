package com.qi.annotitionAop;/*
    name zhang;
    */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Monkey monkey = (Monkey)applicationContext.getBean("monkey");
        monkey.stealPeaches("吼吼");
    }
}
