package com.ming.dao;

import com.ming.po.User;

public interface IUserManager {

    //查询
    public User queryUserById(int id) throws Exception;

    //添加
    public void addUser(User user) throws Exception;

    //删除
    public void delUser(int id) throws Exception;

    //修改
    public void modifyUser(User user,int id) throws Exception;
}
