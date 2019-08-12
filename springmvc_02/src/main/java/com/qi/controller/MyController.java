package com.qi.controller;

import com.qi.po.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class MyController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("访问成功");

        List<Items> list = new ArrayList<Items>();
        list.add(new Items(123,"酸奶",12.0,"畅爽"));
        list.add(new Items(13,"纯奶",15.0,"蒙牛"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/jsp/index01.jsp");
        return modelAndView;
    }
}
