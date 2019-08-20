package com.qi.dao;/*
    name zhang;
    */

import com.qi.po.User;

import java.util.List;

public interface UserDaoI {
    public String userShow();

    List<User> selectAll();

    void insertUser();
}
