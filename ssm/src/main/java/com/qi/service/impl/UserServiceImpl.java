package com.qi.service.impl;

import com.qi.mapper.UserMapper;
import com.qi.po.User;
import com.qi.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        List<User> list = userMapper.getAllUser();
        return list;
    }

}
