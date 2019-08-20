package com.qi.service.impl;/*
    name zhang;
    */

import com.qi.dao.impl.UserDaoImpl;
import com.qi.po.User;
import com.qi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    public String show() {
        return userDao.userShow();
    }

    public void insertUser() {
        userDao.insertUser();
    }

    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
