package com.qi;/*
    name zhang;
    */

import com.qi.mapper.UserMapper;
import com.qi.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void queryUserByID(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try{
            //第一步,得到接口的代理对象
            UserMapper userMaaper = (UserMapper) sqlSession.getMapper(UserMapper.class);
            User user = userMaaper.findUserById(10);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


}
















