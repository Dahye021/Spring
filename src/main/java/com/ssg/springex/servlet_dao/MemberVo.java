package com.ssg.springex.servlet_dao;

import lombok.Data;

import java.sql.Date;

@Data
public class MemberVo {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date joinDate;
}