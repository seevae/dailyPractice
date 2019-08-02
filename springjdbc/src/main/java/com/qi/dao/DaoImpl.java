package com.qi.dao;


import org.springframework.jdbc.core.JdbcTemplate;

public class DaoImpl implements Dao {

    private JdbcTemplate jdbcTemplate; //这个使用的是Spring提供的JDBC模块

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() throws Exception {
        String sql = "insert into man(username,money) values (?,?)";
        int row = jdbcTemplate.update(sql,"大纲村山",1234);
        System.out.println("有"+row+"行数据插入");
    }

}
