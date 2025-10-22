package com.ssg.springex.servlet_basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", value = "/My")
public class MyServlet extends HttpServlet {
    private String message;

    // doget = 요청/응답, 톰켓으로 부터 왓스가 제공해주는 객체
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>My Servlet - KDH</h1>");
        out.println("</body></html>");
    }
}