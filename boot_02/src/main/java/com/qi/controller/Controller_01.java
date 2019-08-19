package com.qi.controller;

import com.qi.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller_01 {

    @Autowired
    private UserServiceI userService;

    @RequestMapping("/hello")
    public String hello(){
        String str = userService.show();
        System.out.println(str);
        return str;
    }
}
