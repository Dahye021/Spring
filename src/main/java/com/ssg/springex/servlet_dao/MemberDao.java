package com.ssg.springex.servlet_dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class MemberDao {
    private Statement stmt;
    private Connection conn;

    private void connDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=Asia/Seoul", "root", "guswnalswn1");

            System.out.println("Connection 생성 성공");
            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MemberVo> listMembers(){
        List<MemberVo> memberList = new ArrayList<>();

        try {
            connDB();
            String sql = "select * from member";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MemberVo member = new MemberVo();
                String id = rs.getString("userId");
                String pwd = rs.getString("userPwd");
                String name = rs.getString("userName");
                String email = rs.getString("userEmail");
                Date joinDate = rs.getDate("joinDate");

                member.setId(id);
                member.setPwd(pwd);
                member.setName(name);
                member.setEmail(email);
                member.setJoinDate(joinDate);
                memberList.add(member);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberList;
    }
}
