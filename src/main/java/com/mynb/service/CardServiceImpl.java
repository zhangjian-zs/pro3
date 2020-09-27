package com.mynb.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mynb.dao.*;
import com.mynb.pojo.*;
import com.mynb.util.MD5;
import com.mynb.vo.ConsumedGoods;
import com.mynb.vo.OrdersDetail;
import com.mynb.vo.StudentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CardServiceImpl implements ICardService{
	private UserinfoMapper userinfoMapper;
	private StudentMapper studentMapper;
	private CollegeMapper collegeMapper;
	private GoodsMapper goodsMapper;
	private OrdersMapper ordersMapper;
	private DingdanMapper dingdanMapper;
	public CardServiceImpl() {
	}

	@Autowired
	public CardServiceImpl(UserinfoMapper userinfoMapper, StudentMapper studentMapper, CollegeMapper collegeMapper, GoodsMapper goodsMapper, OrdersMapper ordersMapper, DingdanMapper dingdanMapper) {
		this.userinfoMapper = userinfoMapper;
		this.studentMapper = studentMapper;
		this.collegeMapper = collegeMapper;
		this.goodsMapper = goodsMapper;
		this.ordersMapper = ordersMapper;
		this.dingdanMapper = dingdanMapper;
	}






	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Userinfo UserLogin(String login, String pwd) {
		return userinfoMapper.selectUserinfoByLoginAndPwd(login, MD5.enctypeMD5("haha"+pwd));
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public PageInfo<Student> listAllStu(Integer page,Integer pageSize) {
		PageHelper.startPage(page,pageSize);
		List<Student> students = studentMapper.listAllStu();
		PageInfo<Student> pages = new PageInfo<>(students);
		
		return pages;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Student selectStuBySid(Integer studentId) {
		return studentMapper.selectByPrimaryKey(studentId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<College> listAllColleges() {
		return collegeMapper.listAllColleges();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean updateStu(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student)>0;
	}

    @Override
    public boolean addStu(Student student) {
        return studentMapper.insertSelective(student)>0;
    }

	@Override
	public boolean delStuBySid(Integer stuId) {
		return studentMapper.deleteByPrimaryKey(stuId)>0;
	}

	@Override
	public List<Student> selectStusByInfo(String info) {
		return studentMapper.selectStusByInfo("%"+info+"%");
	}

	@Override
	public boolean updateUserinfo(Userinfo userinfo) {
		userinfo.setUserPasswd(MD5.enctypeMD5("haha"+userinfo.getUserPasswd()));
		return userinfoMapper.updateByPrimaryKeySelective(userinfo)>0;
	}

	@Override
	public boolean confirmPwd(Integer userId, String newPasswd) {
		Userinfo userinfo = userinfoMapper.selectByPrimaryKey(userId);

		return MD5.enctypeMD5("haha"+newPasswd).equals(userinfo.getUserPasswd());
	}

	@Override
	public List<Goods> listAllGoods() {
		return goodsMapper.listAllGoods();
	}

	@Override
	public boolean addGoods(Goods goods) {
		return goodsMapper.insertSelective(goods)>0;
	}

	@Override
	public boolean delGoods(@RequestBody Integer[] ids) {
		int rt = 0;
		for (Integer id : ids) {
			if(goodsMapper.deleteByPrimaryKey(id)>0) {
				rt++;
			}
		}
		return rt==ids.length;
	}

	@Override
	public Goods selectGoodsById(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Override
	public boolean updateGoods(Goods goods) {
		return goodsMapper.updateByPrimaryKeySelective(goods)>0;
	}

	@Override
	public Student stuLogin(String stuName, String password) {
		return studentMapper.selectStuByLoginAndPass(stuName, MD5.enctypeMD5("haha"+password));
	}

	@Override
	public StudentDetail selStuDetailById(Integer stuId) {
		return studentMapper.selectStudetailById(stuId);
	}

	@Override
	public boolean addOrder(Orders orders) {
		return ordersMapper.insertSelective(orders)>0;
	}

	@Override
	public List<OrdersDetail> listAllOrdersDetails() {
		return ordersMapper.listAllOrdersDetails();
	}

	@Override
	public boolean delOrder(Integer orderId) {
		return ordersMapper.deleteByPrimaryKey(orderId)>0;
	}

	@Override
	public boolean updateOrder(Integer orderId, Integer goodsCount) {
		Orders orders = new Orders();
		orders.setOrderId(orderId);
		orders.setGoodsCount(goodsCount);
		return ordersMapper.updateByPrimaryKeySelective(orders)>0;
	}

	@Override
	public boolean addDingdan(Integer buyCounts) {
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanNo(String.valueOf(System.nanoTime()));
		dingdan.setBuyCounts(buyCounts);
		dingdan.setPayTime(new Date());
		return dingdanMapper.insertSelective(dingdan)>0;
	}

	@Override
	public boolean consumeGoods(ConsumedGoods[] cgs) {
		int rt = 0;
		for (ConsumedGoods cg : cgs) {
			Goods goods = goodsMapper.selectByPrimaryKey(cg.getGoodsId());
			goods.setGoodsLeft((short)(int)(goods.getGoodsLeft()-cg.getGoodsCount()));
			if(goodsMapper.updateByPrimaryKeySelective(goods)>0){
				rt++;
			}

		}
		return rt==cgs.length;
	}

	@Override
	public boolean delOrders(Integer[] ids) {
		int i=0;
		for (Integer id : ids) {
			if(ordersMapper.deleteByPrimaryKey(id)>0){
				i++;
			}
		}
		return i==ids.length;
	}


}
