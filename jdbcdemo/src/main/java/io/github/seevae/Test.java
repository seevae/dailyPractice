package io.github.seevae;/*
    name zhang;
    */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立数据库连接(注意如果使用的mysql较新,在最后面要指定serverTimezone=UTC
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?user=root&password=zhang&serverTimezone=UTC");
            //创建操作对象
            Statement statement = connection.createStatement();
            //写sql,写一个插入写一个查找,查找会返回一个结果集
            //表中插入数据
            statement.execute("insert into Employee values(1,'Jame',22)");
            //表中查询数据
            ResultSet resultSet = statement.executeQuery("select * from Employee");
            //处理结果集
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("id="+id+" name= "+name+" age= "+age);
            }

            //关闭所有连接 注意关闭顺序
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
