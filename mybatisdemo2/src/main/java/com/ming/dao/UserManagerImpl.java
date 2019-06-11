package com.ming.dao;

import com.ming.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

/**
 * SqlSessionFactory
 * SqlSession
 */
public class UserManagerImpl implements IUserManager{

    private SqlSessionFactory sqlSessionFactory = null;

    public UserManagerImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * @param id
     * @return
     * @throws Exception
     */
    //查询操作---MyBatis
    public User queryUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
           User user = (User) sqlSession.selectOne("abc.queryUserById",id);
           return user;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }

    public void addUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            sqlSession.insert("abc.addUser",user);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    //自己玩
    public void delUser(int id) throws Exception {

    }
    //也自己玩
    public void modifyUser(User user, int id) throws Exception {

    }
}
