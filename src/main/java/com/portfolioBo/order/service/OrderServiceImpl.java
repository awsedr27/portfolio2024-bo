package com.portfolioBo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.order.dao.OrderDao;
import com.portfolioBo.order.dao.OrderItemDao;
import com.portfolioBo.order.dto.OrderDto.OrderDetailResult;
import com.portfolioBo.order.dto.OrderDto.OrderItemUpdateQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListCntQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListResult;
import com.portfolioBo.order.dto.OrderServiceDto.OrderItemUpdateServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrdersListServiceDto;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;

	@Override
	public List<OrdersListResult> getOrdersList(OrdersListServiceDto ordersListServiceDto) {
		OrdersListQuery ordersListQuery=new OrdersListQuery(ordersListServiceDto);
		
		int listCnt=orderDao.selectOrdersListCnt(new OrdersListCntQuery(ordersListServiceDto));
		ordersListQuery.getPaging().setTotalRecordCount(listCnt);
		return orderDao.selectOrdersList(ordersListQuery);
	}

	@Override
	public OrderDetailResult getOrdersDetail(Integer orderId) {
		return orderDao.selectOrderDetail(orderId);
	}

	@Override
	public int updateOrderItem(OrderItemUpdateServiceDto orderItemUpdateServiceDto) {
		OrderItemUpdateQuery orderItemUpdateQuery=new OrderItemUpdateQuery(orderItemUpdateServiceDto);
		int result=orderItemDao.updateOrderItem(orderItemUpdateQuery);
		return result;
	}


}
