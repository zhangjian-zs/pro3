package com.mynb.vo;

import com.mynb.pojo.Goods;
import com.mynb.pojo.Student;

import java.util.Date;

public class OrdersDetail {
    private Integer orderId;

    private Student student;

    private Goods goods;

    private Integer goodsCount;

    private Date createTime;

    @Override
    public String toString() {
        return "OrdersDetail{" +
                "orderId=" + orderId +
                ", student=" + student +
                ", goods=" + goods +
                ", goodsCount=" + goodsCount +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
