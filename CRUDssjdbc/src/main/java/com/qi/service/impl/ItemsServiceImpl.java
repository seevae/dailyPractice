package com.qi.service.impl;/*
    name zhang;
    */

import com.qi.dao.ItemsDao;
import com.qi.dao.daoImpl.ItemsDaoImpl;
import com.qi.po.Items;
import com.qi.service.ItemsServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsServiceI {

    @Autowired
    private ItemsDao itemsDao ;


    public List<Items> findAllItems() {
        System.out.println("这里是service");
        List<Items> list = itemsDao.findAllItems();
        return list;
    }
}
