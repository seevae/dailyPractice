package io.github.seevae;/*
    name zhang;
    */

import io.github.seevae.bz.UserGroom;
import io.github.seevae.mapper.UserMapper;
import io.github.seevae.po.User;
import io.github.seevae.po.UserExtend;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyTest {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void myInit(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //resultMap
    @Test
    public void queryUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = (User)userMapper.queryUserById(10);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    //多条件查询
    @Test
    public void queryByMoreCon(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserExtend userExtend = new UserExtend();
            //注意如果此处不设置性别的值,那么默认的是0
            userExtend.setSex(1);
            userExtend.setUsername("张");
            UserGroom userGroom = new UserGroom(userExtend);
            List<UserExtend> list = userMapper.queryByMoreCon(userGroom);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    //出错的示范
    @Test
    public void queryByMoreCon2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
           User user = new User();
           user.setSex(1);
           user.setUsername("张");
           List<User> list =  userMapper.queryByMoreCon2(user);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void queryNumber(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserExtend userExtend = new UserExtend();
            //注意如果此处不设置性别的值,那么默认的是0
            userExtend.setSex(1);
            userExtend.setUsername("张");
            UserGroom userGroom = new UserGroom(userExtend);
            int result = userMapper.queryNumber(userGroom);
            System.out.println("count * = "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    // select ...where .. or .. or ..
    @Test
    public void testForEach(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(26);
            list.add(33);
            UserExtend userExtend = new UserExtend();
            UserGroom userGroom = new UserGroom(userExtend);
            userGroom.setIdList(list);
            List<User> userList = userMapper.testForEach(userGroom);
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

}
