package com.qi.controller;

import com.qi.po.Items;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 通过前端页面直接提交数据,在后端进行数据的接收
 * 两种方式接收前端数据
 * 1.HttpServletRequest
 * 2.参数绑定和前端传过来的参数要对应
 * 3.使用参数对应的实体类来接收,需要注意前端提交的参数名称需要和实体类中字段对应
 */

@Controller
public class Cotroller2 {

    @RequestMapping("/show.do")
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("已经进入到controller");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name+": "+password);
        request.setAttribute("name",name);
        request.setAttribute("password",password);
        //请求转发
        request.getRequestDispatcher("/jsp/02.jsp").forward(request,response);
    }

    @RequestMapping("/show2.do")
    public String show2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("已经进入到controller");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name+": "+password);
        request.setAttribute("name",name);
        request.setAttribute("password",password);
//        //请求转发
//        request.getRequestDispatcher("/jsp/02.jsp").forward(request,response);
        return "/jsp/02.jsp";
    }

    @RequestMapping("/show3")
    //如果参数名字和前端传来的不一样,则需要进行参数绑定,一样的话可以自动绑定
    public void show03(@RequestParam("name") String sname, @RequestParam("password")String spassword){
        System.out.println(sname+" "+spassword);
    }

    //使用实体类的方式来进行数据传递
    @RequestMapping("/show4")
    public void show04(Items items){
        System.out.println(items.getId()+" "+items.getName());
    }

}
