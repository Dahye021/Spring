package com.ssg.springex;

import java.io.*;
import javax.servlet.http.*;        //
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    //init = 인터페이스 끝판왕?
    public void init() {
        message = "안녕하세요 서블릿!";
    }

    // doget = 요청/응답, 톰켓으로 부터 왓스가 제공해주는 객체
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}