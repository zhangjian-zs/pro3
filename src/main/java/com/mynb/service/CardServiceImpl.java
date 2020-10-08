package com.mynb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mynb.dao.*;
import com.mynb.pojo.*;
import com.mynb.util.MD5;
import com.mynb.vo.ConsumedGoods;
import com.mynb.vo.OrdersDetail;
import com.mynb.vo.StudentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CardServiceImpl implements ICardService{
	private UserinfoMapper userinfoMapper;
	private StudentMapper studentMapper;
	private CollegeMapper collegeMapper;
	private GoodsMapper goodsMapper;
	private OrdersMapper ordersMapper;
	private DingdanMapper dingdanMapper;
	private RoleRightsMapper roleRightsMapper;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	public CardServiceImpl() {
	}

	@Autowired
	public CardServiceImpl(RoleRightsMapper roleRightsMapper,UserinfoMapper userinfoMapper, StudentMapper studentMapper, CollegeMapper collegeMapper, GoodsMapper goodsMapper, OrdersMapper ordersMapper, DingdanMapper dingdanMapper) {
		this.roleRightsMapper = roleRightsMapper;
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
	//@Cacheable(cacheNames = "def:stu:sel",key = "123")
	public Student selectStuBySid(Integer studentId) {
		redisTemplate.opsForValue().set("def:stu:sel"+studentId,studentMapper.selectByPrimaryKey(studentId),100, TimeUnit.SECONDS);
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
		redisTemplate.opsForValue().set("def:stu:update"+student.getStuId(),student,100, TimeUnit.SECONDS);

		return studentMapper.updateByPrimaryKeySelective(student)>0;
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	//@CachePut(cacheNames = "def:stu:add",key = "#student.stuId+''")
    public boolean addStu(Student student) {
		redisTemplate.opsForValue().set("def:stu:add"+student.getStuId(),student,100, TimeUnit.SECONDS);
        return studentMapper.insertSelective(student)>0;
    }

	@Override
	//@CacheEvict(cacheNames = "def:stu:del",key = "#stuId+''",allEntries = false)
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean delStuBySid(Integer stuId) {
		redisTemplate.opsForValue().set("def:stu:del"+stuId,stuId+"",100, TimeUnit.SECONDS);
		return studentMapper.deleteByPrimaryKey(stuId)>0;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<Student> selectStusByInfo(String info) {
		return studentMapper.selectStusByInfo("%"+info+"%");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean updateUserinfo(Userinfo userinfo) {
		userinfo.setUserPasswd(MD5.enctypeMD5("haha"+userinfo.getUserPasswd()));
		return userinfoMapper.updateByPrimaryKeySelective(userinfo)>0;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public boolean confirmPwd(Integer userId, String newPasswd) {
		Userinfo userinfo = userinfoMapper.selectByPrimaryKey(userId);

		return MD5.enctypeMD5("haha"+newPasswd).equals(userinfo.getUserPasswd());
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<Goods> listAllGoods() {
		return goodsMapper.listAllGoods();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean addGoods(Goods goods) {
		return goodsMapper.insertSelective(goods)>0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
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
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Goods selectGoodsById(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean updateGoods(Goods goods) {
		return goodsMapper.updateByPrimaryKeySelective(goods)>0;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Student stuLogin(String stuName, String password) {
		return studentMapper.selectStuByLoginAndPass(stuName, MD5.enctypeMD5("haha"+password));
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public StudentDetail selStuDetailById(Integer stuId) {
		return studentMapper.selectStudetailById(stuId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean addOrder(Orders orders) {
		return ordersMapper.insertSelective(orders)>0;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<OrdersDetail> listAllOrdersDetails() {
		return ordersMapper.listAllOrdersDetails();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean delOrder(Integer orderId) {
		return ordersMapper.deleteByPrimaryKey(orderId)>0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean updateOrder(Integer orderId, Integer goodsCount) {
		Orders orders = new Orders();
		orders.setOrderId(orderId);
		orders.setGoodsCount(goodsCount);
		return ordersMapper.updateByPrimaryKeySelective(orders)>0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean addDingdan(Integer buyCounts,String dingdanNo) {
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanNo(dingdanNo);
		dingdan.setBuyCounts(buyCounts);
		dingdan.setPayTime(new Date());
		return dingdanMapper.insertSelective(dingdan)>0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean delOrders(Integer[] ids) {
		int i=0;
		for (Integer id : ids) {
			if(ordersMapper.deleteByPrimaryKey(id)>0){
				i++;
			}
		}
		return i==ids.length;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Userinfo selectUserByName(String userLogin) {
		return userinfoMapper.selectUserByName(userLogin);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Userinfo findRoleByUserLogin(String userLogin) {
		return userinfoMapper.findRoleByUserLogin(userLogin);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public List<Rights> findPermsByRoleId(Integer roleid) {
		return roleRightsMapper.findPermsByRoleId(roleid);
	}


}
