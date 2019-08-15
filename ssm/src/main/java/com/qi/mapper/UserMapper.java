package com.qi.mapper;/*
    name zhang;
    */

import com.qi.po.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getAllUser();
}
