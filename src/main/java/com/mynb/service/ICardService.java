package com.mynb.service;

import com.github.pagehelper.PageInfo;
import com.mynb.pojo.College;
import com.mynb.pojo.Student;
import com.mynb.pojo.Userinfo;

import java.util.List;


public interface ICardService {
	/**
	 * user login
	 * @param login
	 * @param pwd
	 * @return
	 */
	Userinfo UserLogin(String login,String pwd);

	/**
	 * 查询所有学生信息
	 * @return
	 */
	PageInfo<Student> listAllStu(Integer page,Integer pageSize);

	/**
	 * 根据id查询学生信息
	 * @param studentId
	 * @return
	 */
	Student selectStuBySid(Integer studentId);

	/**
	 * 查询所有的college
	 * @return
	 */
	List<College> listAllColleges();

	/**
	 * 更新数据
	 * @param student
	 * @return
	 */
	boolean updateStu(Student student);

	/**
	 * 添加学生信息
	 * @param student
	 * @return
	 */
	boolean addStu(Student student);

	/**
	 * 根据id删除学生信息
	 * @param stuId
	 * @return
	 */
	boolean delStuBySid(Integer stuId);

	/**
	 * 根据查询信息查询学生
	 * @param info
	 * @return
	 */
    List<Student> selectStusByInfo(String info);

	/**
	 * 更新用户信息
	 * @param userinfo
	 * @return
	 */
	boolean updateUserinfo(Userinfo userinfo);

	/**
	 * 验证旧密码是否正确
	 * @param userId
	 * @param newPasswd
	 * @return
	 */
	boolean confirmPwd(Integer userId, String newPasswd);
}
