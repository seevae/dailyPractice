package com.qi.Test;
import com.qi.mapper.UserMapper;
import com.qi.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        String resourse  = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resourse);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //添加
        User user = new User();
        user.setUsername("大夏武士");
        user.setSex(1);
        user.setAddress("夏朝");
        userMapper.add(user);
//
//        //删除
//        userMapper.del(38);

        //还是要注意,删除,添加操作等要注意事务的提交
        sqlSession.commit();

        //查找
        List<User> list = userMapper.select();
        for(User s:list){
            System.out.println(s);
        }
    }
}
