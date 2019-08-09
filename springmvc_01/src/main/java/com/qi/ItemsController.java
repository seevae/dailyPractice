package com.qi;/*
    name zhang;
    */


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ItemsController implements Controller {


    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        System.out.println(11111);
        List<Items> lItems=new ArrayList<Items>();
        Items items=new Items(2018001, "保温衣服", 69.0, "最暖和的保暖棉衣！！");
        Items items2=new Items(2018002, "纯棉围脖", 39.0, "夏天都可以带的围脖！！");

        lItems.add(items);
        lItems.add(items2);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemslist", lItems);
        modelAndView.setViewName("user-list.jsp");
        System.out.println("封装完毕,返回到页面");

        return modelAndView;
    }

}
