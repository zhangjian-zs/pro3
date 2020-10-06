package com.mynb.dao;

import com.mynb.pojo.Rights;
import com.mynb.pojo.RoleRights;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRightsMapper {
    int deleteByPrimaryKey(Integer rrid);

    int insert(RoleRights record);

    int insertSelective(RoleRights record);

    RoleRights selectByPrimaryKey(Integer rrid);

    int updateByPrimaryKeySelective(RoleRights record);

    int updateByPrimaryKey(RoleRights record);

    /**
     * 根据roleid查询权限
     * @param roleid
     * @return
     */
    List<Rights> findPermsByRoleId(Integer roleid);
}