package io.github.seevae;/*
    name zhang;
    */

import io.github.seevae.mapper.UserManager;
import io.github.seevae.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserByID(){
       SqlSession sqlSession =  sqlSessionFactory.openSession();
       try{
           //第一步: 得到接口的代理对象
           UserManager userManager = (UserManager) sqlSession.getMapper(UserManager.class);
           //第二步: 使用接口中的方法
           User user =  userManager.queryUserById(33);
           System.out.println(user);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           sqlSession.close();
       }
    }


    /**
     * resultType和resultMap的区别
     */
    @Test
    public void queryUserByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //第一步: 拿到接口的反射对象
            UserManager userManager = (UserManager) sqlSession.getMapper(UserManager.class);
            //调用接口中的方法
            List<User> userList =  userManager.queryUserByName("张");
            System.out.println(userList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }



}
