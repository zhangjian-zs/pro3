package com.mynb.dao;

import com.mynb.pojo.Rights;

public interface RightsMapper {
    int deleteByPrimaryKey(Integer rightid);

    int insert(Rights record);

    int insertSelective(Rights record);

    Rights selectByPrimaryKey(Integer rightid);

    int updateByPrimaryKeySelective(Rights record);

    int updateByPrimaryKey(Rights record);
}