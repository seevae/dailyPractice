package com.qi;/*
    name zhang;
    */

import com.qi.mapper.Mapper;
import com.qi.mybatisTools.MybatisTools;
import com.qi.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {
        String config = "sqlMapConfig.xml";
        SqlSession sqlSession = MybatisTools.getSession(config);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
//        System.out.println("请键盘输入要模糊查询的内容");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        //在传递值的时候拼接sql
//        List<User> list =  mapper.findlikeUser("%"+s+"%");
//        System.out.println(list.size());


////        插入数据
//        User user = new User();
//        user.setUsername("火车侠");
//        user.setSex(2);
//        user.setAddress("铁道");
//        mapper.add(user);
//        sqlSession.commit();
//        User list = mapper.queryUserById(16);
//        System.out.println(list);

         List<Map<String,String>> list  =  mapper.getList();
         System.out.println(list);
    }
}
