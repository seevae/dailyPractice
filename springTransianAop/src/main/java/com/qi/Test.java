package com.qi;/*
    name zhang;
    */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Service;

public class Test {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceImp serviceImp = (ServiceImp) applicationContext.getBean("ServiceImp",ServiceImp.class);
        serviceImp.seadd();
    }
}
