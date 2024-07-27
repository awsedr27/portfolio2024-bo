package com.portfolioBo.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrdersListCntQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListQuery;

@Mapper
public interface OrderDao {

	int selectOrdersListCnt(OrdersListCntQuery ordersListCntQuery);

	List<OrderDto> selectOrdersList(OrdersListQuery ordersListQuery);
	
	

}
