package com.qi;/*
    name zhang;
    */

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 */

public class Conn {

    static {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","zhang");
    }
}
