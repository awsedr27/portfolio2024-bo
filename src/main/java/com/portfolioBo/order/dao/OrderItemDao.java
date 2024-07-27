package com.portfolioBo.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.order.dto.OrderDto.OrderItem;

@Mapper
public interface OrderItemDao {

	List<OrderItem> selectOrderItemListByOrderId(Integer orderId);

}
