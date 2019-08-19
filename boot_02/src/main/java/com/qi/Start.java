package com.qi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.qi.controller","com.qi.dao","com.qi.po","com.qi.service"})
public class Start {

    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }
}
