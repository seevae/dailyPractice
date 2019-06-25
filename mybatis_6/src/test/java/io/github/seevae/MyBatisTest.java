package io.github.seevae;/*
    name zhang;
    */

import io.github.seevae.mapper.OrderMapper;
import io.github.seevae.po.Orders;
import io.github.seevae.po.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void myInit() throws IOException {
        String file = "sqlMapConfig.xml";
        InputStream  inputStream = Resources.getResourceAsStream(file);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testQueryOrderUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper =  sqlSession.getMapper(OrderMapper.class);
        List<Orders> ordersList = orderMapper.queryOrderUser();
        //延迟user
        for(Orders orders:ordersList){
            User user = orders.getUser();
            System.out.println(user);
        }

        sqlSession.close();

    }


}
