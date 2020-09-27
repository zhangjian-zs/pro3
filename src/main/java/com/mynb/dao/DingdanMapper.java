package com.mynb.dao;

import com.mynb.pojo.Dingdan;
import org.springframework.stereotype.Repository;

@Repository
public interface DingdanMapper {
    int deleteByPrimaryKey(Integer dingdanId);

    int insert(Dingdan record);

    int insertSelective(Dingdan record);

    Dingdan selectByPrimaryKey(Integer dingdanId);

    int updateByPrimaryKeySelective(Dingdan record);

    int updateByPrimaryKey(Dingdan record);
}