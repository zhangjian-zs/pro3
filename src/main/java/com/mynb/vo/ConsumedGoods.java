package com.mynb.vo;

import java.io.Serializable;

public class ConsumedGoods implements Serializable {
    private Integer goodsId;
    private Integer goodsCount;

    @Override
    public String toString() {
        return "ConsumedGoods{" +
                "goodsId=" + goodsId +
                ", goodsCount=" + goodsCount +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}
