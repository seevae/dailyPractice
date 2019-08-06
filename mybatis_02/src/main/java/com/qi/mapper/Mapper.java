package com.qi.mapper;/*
    name zhang;
    */

import com.qi.bz.UserGroom;
import com.qi.po.User;
import com.qi.po.UserExtend;

import java.util.List;
import java.util.Map;

public interface Mapper {
    public List<User> findlikeUser(String value) throws Exception;
    public List<User> findUser(String value) throws Exception;
    public void add(User user) throws Exception;

    public User findUserById(int id) throws Exception;
    public User queryUserById(int id) throws Exception;
    public List<Map<String,String>> getList() throws Exception;

    public List<UserExtend> queryByMoreCon(UserGroom userGroom) throws Exception;
    public int queryNumber(UserGroom userGroom) throws Exception;
}
