package com.portfolioBo.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrdersListResult;
import com.portfolioBo.order.dto.OrderDto.OrderDetailResult;
import com.portfolioBo.order.dto.OrderDto.OrderItemListResult;
import com.portfolioBo.order.dto.OrderDto.OrdersListCntQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListQuery;

@Mapper
public interface OrderDao {

	int selectOrdersListCnt(OrdersListCntQuery ordersListCntQuery);

	List<OrdersListResult> selectOrdersList(OrdersListQuery ordersListQuery);
	
	OrderDetailResult selectOrderDetail(Integer orderId);


}
