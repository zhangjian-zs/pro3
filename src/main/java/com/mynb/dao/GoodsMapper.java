package com.mynb.dao;

import com.mynb.pojo.Goods;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(int goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(int goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> listAllGoods();
}