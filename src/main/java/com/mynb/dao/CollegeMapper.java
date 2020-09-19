package com.mynb.dao;

import com.mynb.pojo.College;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

    List<College> listAllColleges();
}