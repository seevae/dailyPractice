package com.qi;/*
    name zhang;
    */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Properties;

public class Test {

    public static int getValue(int i){
        int result = 0;
        switch(i){
            case 1:result = result+i;
            case 2:result = result+i*2;
            case 3:result = result+i*3;
            default:result += i;
        }
        return result;
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});
//        Dept dept = (Dept) applicationContext.getBean("dept");
////        User user01 = (User) applicationContext.getBean("user01");
////        System.out.println(user01.getBirthday());
//
//        System.out.println(dept.getAddress() + " " + dept.getDeptname());
//
////        //获取集合中的数据
////        for(User user:dept.getUserList()){
////            System.out.println(user.getName()+" "+user.getAddress()+" "+user.getAge());
////        }
//
//        //获取集合中的数据
//        for(User user:dept.getUserSet()){
//            System.out.println(user.getName()+" "+user.getAddress()+" "+user.getAge());
//        }
//
//        for (Map.Entry<String,User> uString: dept.getUserMap().entrySet()){
//            System.out.println(uString.getKey()+" "+uString.getValue().getName());
//        }
//
//        //        Map<String,User> map = dept.getUserMap();
//
//        System.out.println("properties注入: ");
//        Properties properties = dept.getProperties();
//        System.out.println(properties.getProperty("driver"));
//
//
//        for(Map.Entry<Object, Object> string:dept.getProperties().entrySet()){
//            System.out.println(string.getKey()+" "+string.getValue().toString());
//        }


////        测试一下bean对象的作用范围
//        ApplicationContext applicationContext3 = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});
//        User u1 = (User) applicationContext3.getBean("user02");
//        User u2 = (User) applicationContext3.getBean("user02");
//        System.out.println(u1+" "+u2);

        int a = getValue(2);
        System.out.println(a);


    }
}
