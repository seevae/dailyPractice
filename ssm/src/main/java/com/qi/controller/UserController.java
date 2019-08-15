package com.qi.controller;/*
    name zhang;
    */


import com.qi.po.User;
import com.qi.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceI userService;

    @RequestMapping("/getUserNum")
    public void getNum(){

        List<User> list = userService.getAllUser();
        for(User u:list){
            System.out.println(u);
        }

    }

}
