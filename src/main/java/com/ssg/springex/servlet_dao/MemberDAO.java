package com.ssg.springex.servlet_dao;


import java.sql.*;

public class MemberDAO {

    private Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pwd = "guswnalswn1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean insertMember(MemberVo vo) {
        boolean result = false;
        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO memberInfo(name, pwd, gender, hobby, joinDate) VALUES(?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPwd());
            pstmt.setString(3, vo.getGender());
            pstmt.setString(4, vo.getHobby());
            java.util.Date utilDate = vo.getDate();
            if(utilDate != null){
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                pstmt.setDate(5, sqlDate);
            } else {
                pstmt.setDate(5, null);
            }

            int cnt = pstmt.executeUpdate();
            result = (cnt > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
        return result;
    }
}