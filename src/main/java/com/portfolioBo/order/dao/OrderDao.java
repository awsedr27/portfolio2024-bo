package com.portfolioBo.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrderDetailResult;
import com.portfolioBo.order.dto.OrderDto.OrderUpdateQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListCntQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListResult;

@Mapper
public interface OrderDao {

	int selectOrdersListCnt(OrdersListCntQuery ordersListCntQuery);

	List<OrdersListResult> selectOrdersList(OrdersListQuery ordersListQuery);
	
	OrderDetailResult selectOrderDetail(Integer orderId);

	int updateOrder(OrderUpdateQuery orderUpdateQuery);

	OrderDto selectOrderWithExclusiveLock(Integer orderId);


}
