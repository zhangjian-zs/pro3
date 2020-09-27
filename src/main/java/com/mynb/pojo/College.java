package com.mynb.pojo;

import org.springframework.beans.factory.BeanNameAware;

import java.io.Serializable;

public class College implements Serializable {

    private Integer collegeId;

    private String collegeName;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}