package com.qi.controller;

import com.qi.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class Controller01 {

    @RequestMapping("/ab.do")
    public ModelAndView method01(){
        System.out.println("访问到了");
        List<Items> list = new ArrayList<Items>();
        list.add(new Items(01,"流奶",12.0,"好喝的特仑苏"));
        list.add(new Items(02,"拉条",11.5,"好吃的牛板筋"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/jsp/index01.jsp");
        return modelAndView;
    }
}
