package com.qi.controller;

import com.qi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qi.po.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("user")
    public String uer(){
        return userService.show();
    }

    @RequestMapping("select")
    public List<User> selectAll(){
        return userService.selectAll();
    }

    @RequestMapping("/insert")
    public void insertUser(){
        userService.insertUser();
    }

}
