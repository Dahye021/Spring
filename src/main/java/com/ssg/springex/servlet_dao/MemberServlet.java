package com.ssg.springex.servlet_dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDao dao = new MemberDao();

        List<MemberVo> memberList = dao.listMembers();//회원 정보 조회 결과인 회원 정보 리스트 return

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.println("<th>ID</th><th>Name</th><th>Email</th><th>Date</th></tr>");
        for (int i = 0; i < memberList.size(); i++) {
            String id = memberList.get(i).getId();
            String name = memberList.get(i).getName();
            String email = memberList.get(i).getEmail();
            Date date = memberList.get(i).getJoinDate();

            out.println("<tr><td>"+ id+"</td>"+"<td>"+ name +"</td>"+"<td>"+ email +"</td>"+"<td>"+ date +"</td></tr>");
        }
        out.println("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}