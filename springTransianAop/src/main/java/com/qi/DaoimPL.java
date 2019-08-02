package com.qi;/*
    name zhang;
    */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class DaoimPL implements Dao {

    @Resource //实现自动装配的 和@AutoWired有点类似
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() throws Exception {
        String sql = "insert into man(username,money) values ('武器大师',3333)";
        int row = jdbcTemplate.update(sql);
        System.out.println(row);
    }

}
