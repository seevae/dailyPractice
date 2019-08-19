package com.qi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qi.po.*;

@RestController  //返回的都是json
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class UserController {

    private User user;

    @RequestMapping("/user")
    public User user(){
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(BootController.class,args);
    }

}
