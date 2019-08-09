package com.qi;/*
    name zhang;
    */

import com.qi.mapper.UserMapper;
import com.qi.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        List<User> list = userMapper.findAllUser();
        for(User u: list){
            System.out.println(u);
        }
    }
}
