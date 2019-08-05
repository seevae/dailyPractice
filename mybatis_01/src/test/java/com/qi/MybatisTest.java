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
import java.util.List;

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
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void delById(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try{
            //第一步,得到接口的代理对象
            UserMapper userMaaper = sqlSession.getMapper(UserMapper.class);
            userMaaper.del(33);
            //一定要注意事务要进行提交,否则是没有变化的
            sqlSession.commit();
            System.out.println("删除完毕");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try{
            //第一步,得到接口的代理对象
            UserMapper userMaaper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("小黄同学");
            user.setSex(1);
            user.setAddress("欧洲");
            userMaaper.insertUser(user);
            sqlSession.commit();
            System.out.println("插入结束");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updatebyid(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try{
            //第一步,得到接口的代理对象
            UserMapper userMaaper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("斯巴达");
            user.setId(36);
            userMaaper.updatebyid(user);
            sqlSession.commit();
            System.out.println("修改成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findAll(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try{
            //第一步,得到接口的代理对象
            UserMapper userMaaper = sqlSession.getMapper(UserMapper.class);
            List<User> list = userMaaper.findAll();
            sqlSession.commit();
            for(User u: list){
                System.out.println(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

}
















