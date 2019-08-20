package com.qi.dao.impl;

import com.qi.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.qi.po.*;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDaoI {

    @Autowired
    private User user;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String userShow() {
        return  user.getUsername()+" "+user.getId();
    }

    public List<User> selectAll() {
        String sql = "select * from user_001";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql,rowMapper);
        for(User user:list){
            System.out.println(user.getUsername()+" "+user.getId());
        }
        return list;
    }

    public void insertUser() {
        String sql = "insert into user_001 (username) values(?)";
        jdbcTemplate.update(sql,"火焰鼠");
        System.out.println("插入完成");
    }

}
