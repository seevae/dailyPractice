package com.qi.dao;


import com.qi.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

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

    public void del() throws Exception {
        String sql = "delete from man where id = ?";
        int resut = jdbcTemplate.update(sql,2);
        System.out.println("删除了"+resut+"条数据");
    }

    public void update() throws Exception {
        String sql = "update man set username='冈本次目' where id=? ";
        int res = jdbcTemplate.update(sql,3);
        System.out.println("更新了"+res+"条数据");
    }

    public void select() throws Exception {
        String sql = "select * from man";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql,rowMapper);
        for(User u: list){
            System.out.println(u.getUsername() +" "+u.getMoney());
        }
    }

}
