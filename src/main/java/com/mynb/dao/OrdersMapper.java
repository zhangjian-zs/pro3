package com.mynb.dao;

import com.mynb.pojo.Orders;
import com.mynb.vo.OrdersDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /**
     * 查询所有购物车订单的详细信息
     * @return
     */
    List<OrdersDetail> listAllOrdersDetails();
}