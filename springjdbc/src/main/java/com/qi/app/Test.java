package com.qi.app;/*
    name zhang;
    */


import com.qi.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service) applicationContext.getBean("service");
        service.serAdd();
    }
}
