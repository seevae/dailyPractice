package com.qi.aop;/*
    name zhang;
    */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}
                );

        try{
            //找到代理类
            ServiceInter customerService = applicationContext.getBean("proxyFactoryBean",ServiceInter.class);
            customerService.sayHello();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
