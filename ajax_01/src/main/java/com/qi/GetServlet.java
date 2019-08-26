package com.qi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/getServlet")
public class GetServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入了psot请求");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name+" "+password);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax请求已经到来");
        response.getWriter().write("hello,ajax");
    }
}
