package com.qi.service.impl;/*
    name zhang;
    */

import com.qi.dao.UserDao;
import com.qi.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserDao userDao;


    public String show() {

        return userDao.show();
    }
}
