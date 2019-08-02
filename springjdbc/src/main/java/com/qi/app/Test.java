package com.qi.app;

import com.qi.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = (Service) applicationContext.getBean("service");

        //添加的操作
        service.serAdd();
        System.out.println("-------------------------");

        //查询的操作
        service.serSelect();
        System.out.println("-------------------------");

        //更新的操作
        service.serUpdate();
        System.out.println("-------------------------");

        //删除的操作
        service.serDel();
        service.serSelect();
    }
}
