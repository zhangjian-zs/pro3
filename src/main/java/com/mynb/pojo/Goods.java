package com.mynb.pojo;

public class Goods {
    private Short goodsId;

    private String goodsName;

    private Double goodsPrice;

    private Short goodsLeft;

    private String goodsDetail;

    private String goodsPicture;

    public Short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Short goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Short getGoodsLeft() {
        return goodsLeft;
    }

    public void setGoodsLeft(Short goodsLeft) {
        this.goodsLeft = goodsLeft;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture == null ? null : goodsPicture.trim();
    }
}