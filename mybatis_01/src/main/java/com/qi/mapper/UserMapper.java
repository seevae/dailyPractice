package com.qi.mapper;/*
    name zhang;
    */

import com.qi.po.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id) throws Exception;
    public void del(int id) throws Exception;
    public void insertUser(User user) throws Exception;
    public void updatebyid(User user) throws Exception;
    public List<User> findAll() throws Exception;
}
