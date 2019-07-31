package com.qi.Sspringextends01;/*
    name zhang;
    */

import com.qi.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"bean02.xml"});
        SmallStu smallStu = (SmallStu) applicationContext.getBean("smallStu");
        System.out.println(smallStu.getEatMilk());
        System.out.println(smallStu.getName());
    }
}
