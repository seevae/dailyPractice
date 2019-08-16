package com.qi.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
@Configuration
public class BootController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "我是一个boot程序!";
    }

    public static void main(String[] args) {
        SpringApplication.run(BootController.class,args);
    }

}
