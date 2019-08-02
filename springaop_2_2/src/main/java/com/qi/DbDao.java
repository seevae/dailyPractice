package com.qi;/*
    name zhang;
    */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDao {

    Connection connection = null;

    public void updata1() throws SQLException {

        connection = Conn.getConnection();

        PreparedStatement preparedStatement = null;

//        try{
//            int c=1/0;
//        }catch (Exception e){
//            System.out.println("有异常");
//            //事务回滚
//            connection.rollback();
//        }

        String sql1 = "update employee set age=33 where name = 'Jame' ";
        preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.execute();

//        connection.commit();

    }

    public void updata() throws SQLException {
        connection = Conn.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = null;
        String sql = "Update man set money = money+200 where id=1";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        try{
            int c=1/0;
            String sql2 = "Update man set money = money-200 where id=2";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.execute();
        }catch (Exception e){
            System.out.println("出现异常");
            connection.rollback();
        }

        connection.commit();
    }

}
