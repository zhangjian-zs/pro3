package com.mynb.dao;

import com.mynb.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    Userinfo selectUserinfoByLoginAndPwd(@Param("login") String login, @Param("pwd") String pwd);
}