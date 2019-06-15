package io.github.seevae;/*
    name zhang;
    */

import io.github.seevae.mapper.OrdersMapper;
import io.github.seevae.po.Orders;
import io.github.seevae.po.OrdersExtend;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoTest {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void myInit() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserWithOrder(){
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = (OrdersMapper) sqlSession.getMapper(OrdersMapper.class);
            List<OrdersExtend> orders = ordersMapper.findUserWithOrder();
            System.out.println(orders);
            //此时list中有三个Orders  ,打印出来的是他们的地址
            //想要打印出查询表中的内容 思路: --> 拿到ordersExtends的反射对象,通过反射对象拿到父类的属性在打印
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserWithOrder2(){
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = (OrdersMapper) sqlSession.getMapper(OrdersMapper.class);
            List<OrdersExtend> orders = ordersMapper.findUserWithOrder();
            System.out.println(orders);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findOrderOrderDetailRM(){
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = (OrdersMapper) sqlSession.getMapper(OrdersMapper.class);
            List<OrdersExtend> orders = ordersMapper.findOrderOrderDetailRM();
            System.out.println(orders);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void findUserToItems(){
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        try{
            OrdersMapper ordersMapper = (OrdersMapper) sqlSession.getMapper(OrdersMapper.class);
            List<OrdersExtend> orders = ordersMapper.findUserToItems();
            System.out.println(orders);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

}
