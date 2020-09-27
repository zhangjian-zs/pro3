package com.mynb.pojo;

import java.util.Date;

public class Dingdan {
    private Integer dingdanId;

    private String dingdanNo;

    private Integer buyCounts;

    private Date payTime;

    public Integer getDingdanId() {
        return dingdanId;
    }

    public void setDingdanId(Integer dingdanId) {
        this.dingdanId = dingdanId;
    }

    public String getDingdanNo() {
        return dingdanNo;
    }

    public void setDingdanNo(String dingdanNo) {
        this.dingdanNo = dingdanNo == null ? null : dingdanNo.trim();
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}