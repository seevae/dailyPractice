package com.qi.mapper;/*
    name zhang;
    */

import com.qi.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user (username,sex,address) values(#{username},#{sex},#{address})")
    public void add(User user) throws Exception;

    @Select("select * from user")
    public List<User> select() throws Exception;

    @Delete("delete from user where id=#{id}")
    public void del(int id) throws Exception;

}
