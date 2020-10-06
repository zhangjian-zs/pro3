package com.mynb.dao;

import com.mynb.pojo.RoleRights;

public interface RoleRightsMapper {
    int deleteByPrimaryKey(Integer rrid);

    int insert(RoleRights record);

    int insertSelective(RoleRights record);

    RoleRights selectByPrimaryKey(Integer rrid);

    int updateByPrimaryKeySelective(RoleRights record);

    int updateByPrimaryKey(RoleRights record);
}