package com.qi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestBatch {
    public static void main(String[] args) throws SQLException {
        Batch();
    }

    public static void Batch() throws SQLException {
        Connection connection = Conn.getConnection();
        String sql = "insert into stu2 values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i=0;i<1000;i++){
            preparedStatement.setInt(1,i+1);
            preparedStatement.setString(2,"stu"+i);
            preparedStatement.setInt(3,i+1);
            preparedStatement.setString(4,i%2==0?"男":"女");
            preparedStatement.addBatch();
        }

        long start = System.currentTimeMillis();
        preparedStatement.executeBatch();  //执行批处理
        long end  = System.currentTimeMillis();
        System.out.println("当前耗费时间"+(end-start));
    }
}
