package com.ssg.springex.servlet_dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberVo {
    private String name;
    private String pwd;
    private String gender;
    private String hobby;
    private Date date;
}