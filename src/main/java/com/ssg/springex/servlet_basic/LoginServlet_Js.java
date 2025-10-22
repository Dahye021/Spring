package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login2")
public class LoginServlet_Js extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet() 메소드 호출");
        doHandle(request,response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doHandle 메소드 호출");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        String user_address = request.getParameter("user_address");

        String data = "<html>";
        data += "<body>";
        data += "<p>" + user_id + "님 로그인 되었습니다."+ "</p>";
        data += "<p>" + user_pwd + "</p>";
        data += "<p>" + user_address + "</p>";
        data += "<a href= 'http://localhost:8080/login2.html'> 로그인 화면 </a>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost메소드 호출");
        doHandle(request,response);
    }
}
