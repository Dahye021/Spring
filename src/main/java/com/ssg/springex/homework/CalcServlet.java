package com.ssg.springex.homework;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calcServlet", value = "/calc")
public class CalcServlet extends HttpServlet {

    // doGet = 클라이언트 요청 처리
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        // GET 파라미터 읽기
        String xStr = request.getParameter("x");
        String yStr = request.getParameter("y");
        String op = request.getParameter("op");

        // 입력 검증
        if (xStr == null || yStr == null || op == null) {
            out.println("<h3>잘못된 요청입니다. x, y, op 모두 전달해주세요.</h3>");
            return;
        }

        int x = 0, y = 0;
        try {
            x = Integer.parseInt(xStr);
            y = Integer.parseInt(yStr);
        } catch (NumberFormatException e) {
            out.println("<h3>숫자를 올바르게 입력해주세요.</h3>");
            return;
        }

        // 연산 처리
        int result = 0;
        String symbol = "";
        switch (op) {
            case "add":
                result = x + y;
                symbol = "+";
                break;
            case "sub":
                result = x - y;
                symbol = "-";
                break;
            case "mul":
                result = x * y;
                symbol = "*";
                break;
            case "div":
                if (y == 0) {
                    out.println("<h3>0으로 나눌 수 없습니다.</h3>");
                    return;
                }
                result = x / y;
                symbol = "/";
                break;
            default:
                out.println("<h3>잘못된 연산자입니다.</h3>");
                return;
        }

        // 결과 출력 (HTML)
        out.println("<!DOCTYPE html>");
        out.println("<html lang='ko'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>계산 결과</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h2>%d %s %d = %d</h2>", x, symbol, y, result);
        out.println("</body>");
        out.println("</html>");
    }
}