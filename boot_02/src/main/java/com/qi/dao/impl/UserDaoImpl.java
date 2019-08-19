package com.qi.dao.impl;

import com.qi.dao.UserDao;
import com.qi.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private User user;

    public String show() {
        String str = user.getName()+": "+user.getSex()+"hhahha";
        return str;
    }

}