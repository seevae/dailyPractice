package com.qi.dao.daoImpl;/*
    name zhang;
    */

import com.qi.dao.ItemsDao;
import com.qi.po.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ItemsDaoImpl implements ItemsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Items> findAllItems() {
        System.out.println("这里是dao");
        String sql = "select * from items";
        Class s = Items.class;
        List<Items> list = jdbcTemplate.queryForList(sql,s);
        for(Items i:list){
            System.out.println(i);
        }
        return list;
    }
}
