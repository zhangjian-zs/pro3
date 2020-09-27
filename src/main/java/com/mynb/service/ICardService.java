package com.mynb.service;

import com.github.pagehelper.PageInfo;
import com.mynb.pojo.*;
import com.mynb.vo.ConsumedGoods;
import com.mynb.vo.OrdersDetail;
import com.mynb.vo.StudentDetail;

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

	/**
	 * 查询所有的商品
	 *
	 * @return
	 */
	List<Goods> listAllGoods();


	/**
	 * 添加商品
	 * @return
	 */
	boolean addGoods(Goods goods);

	/**
	 * s删除商品
	 * @param ids
	 * @return
	 */
	boolean delGoods(Integer[] ids);


	Goods selectGoodsById(Integer goodsId);

	/**
	 * 修改goods对象
	 * @param goods
	 * @return
	 */
	boolean updateGoods(Goods goods);

	/**
	 * student login method
	 * @param stuName
	 * @param password
	 * @return
	 */
	Student stuLogin(String stuName, String password);


	/**
	 * 根据id获取学生详细信息
	 * @param stuId
	 * @return
	 */
	StudentDetail selStuDetailById(Integer stuId);

	/**
	 * 添加购物信息
	 * @param orders
	 * @return
	 */
	boolean addOrder(Orders orders);

	/**
	 * 查询所有购物车订单的属性
	 * @return
	 */
	List<OrdersDetail> listAllOrdersDetails();

    boolean delOrder(Integer orderId);

	boolean updateOrder(Integer orderId, Integer goodsCount);

	boolean addDingdan(Integer buyCounts);

	/**
	 * 消费商品之后进行对应商品数量的减少
	 * @param
	 * @return
	 */
	boolean consumeGoods(ConsumedGoods[] cgs);

	/**
	 * 删除id对应的order
	 * @param ids
	 * @return
	 */
	boolean delOrders(Integer[] ids);
}
