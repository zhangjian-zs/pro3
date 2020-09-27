package com.mynb.dao;

import com.mynb.pojo.Student;
import com.mynb.vo.StudentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 查询学生信息
     * @return
     */
    List<Student> listAllStu();

    /**
     * 模糊查询：根据查询信息查询学生
     * @param info
     * @return
     */
    List<Student> selectStusByInfo(String info);

    /**
     * stu login
     * @param stuName
     * @param password
     * @return
     */
    Student selectStuByLoginAndPass(@Param("login") String stuName, @Param("pwd") String password);


    StudentDetail selectStudetailById(Integer stuId);
}