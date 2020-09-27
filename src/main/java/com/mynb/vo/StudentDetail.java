package com.mynb.vo;

import com.mynb.pojo.College;

public class StudentDetail {
    private Integer stuId;

    private String stuNo;

    private String stuName;

    private String stuLogin;

    private String stuPasswd;

    private String stuPhone;

    private Integer stuLimit;

    private Integer stuRemain;

    private String stuNote;

    private College college;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuLogin() {
        return stuLogin;
    }

    public void setStuLogin(String stuLogin) {
        this.stuLogin = stuLogin;
    }

    public String getStuPasswd() {
        return stuPasswd;
    }

    public void setStuPasswd(String stuPasswd) {
        this.stuPasswd = stuPasswd;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public Integer getStuLimit() {
        return stuLimit;
    }

    public void setStuLimit(Integer stuLimit) {
        this.stuLimit = stuLimit;
    }

    public Integer getStuRemain() {
        return stuRemain;
    }

    public void setStuRemain(Integer stuRemain) {
        this.stuRemain = stuRemain;
    }

    public String getStuNote() {
        return stuNote;
    }

    public void setStuNote(String stuNote) {
        this.stuNote = stuNote;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
