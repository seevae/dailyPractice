package com.ming;

import com.ming.dao.IUserManager;
import com.ming.dao.UserManagerImpl;
import com.ming.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void myInit(){
        try {
            String strFile = "sqlMapConfig.xml";
            InputStream is = Resources.getResourceAsStream(strFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserById(){
        IUserManager iusermanager = new UserManagerImpl(sqlSessionFactory);
        try {
          User user =  iusermanager.queryUserById(1);
          System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddUser(){
        IUserManager iusermanager = new UserManagerImpl(sqlSessionFactory);
        try {
            User user = new User();
            user.setUsername("HHH");
            iusermanager.addUser(user);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
