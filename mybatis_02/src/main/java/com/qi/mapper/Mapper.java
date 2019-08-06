package com.qi.mapper;/*
    name zhang;
    */

import com.qi.po.User;

import java.util.List;
import java.util.Map;

public interface Mapper {
    public List<User> findlikeUser(String value) throws Exception;
    public List<User> findUser(String value) throws Exception;
    public void add(User user) throws Exception;

    public User findUserById(int id) throws Exception;
    public User queryUserById(int id) throws Exception;
    public List<Map<String,String>> getList() throws Exception;
}
