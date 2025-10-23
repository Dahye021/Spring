package com.ssg.springex.servlet_dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/memberRegister.do")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        // 1. HTML 폼 데이터 받기
        String name = request.getParameter("user_id");
        String pwd = request.getParameter("user_pwd");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobby");

        String hobbyStr = "";
        if (hobbies != null) {
            hobbyStr = String.join(",", hobbies);
        }

        // 2. VO에 담기
        MemberVo vo = new MemberVo();
        vo.setName(name);
        vo.setPwd(pwd);
        vo.setGender(gender);
        vo.setHobby(hobbyStr);
        vo.setDate(new Date());

        // 3. DAO 호출
        MemberDAO dao = new MemberDAO();
        boolean success = dao.insertMember(vo);

        // 4. 결과 메시지 설정
        if (success) {
            request.setAttribute("message", name + " 님 회원가입 성공하였습니다.");
            System.out.println(name + "님 회원가입 성공");
        } else {
            request.setAttribute("message", "다시 시도해주세요.");
        }

        // 5. JSP로 이동
        RequestDispatcher rd = request.getRequestDispatcher("memberRegister.jsp");
        rd.forward(request, response);


    }
}