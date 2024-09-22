package com.portfolioBo.order.dao;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.order.dto.OrderDto.OrderItemUpdateQuery;

@Mapper
public interface OrderItemDao {

	int updateOrderItem(OrderItemUpdateQuery orderItemUpdateQuery);


}
