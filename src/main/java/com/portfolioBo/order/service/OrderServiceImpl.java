package com.portfolioBo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.order.dao.OrderDao;
import com.portfolioBo.order.dao.OrderItemDao;
import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrdersListQuery;
import com.portfolioBo.order.dto.OrderDto.OrderItem;
import com.portfolioBo.order.dto.OrderDto.OrdersListCntQuery;
import com.portfolioBo.order.dto.OrderServiceDto.OrdersListServiceDto;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;

	@Override
	public List<OrderDto> getOrdersList(OrdersListServiceDto ordersListServiceDto) {
		OrdersListQuery ordersListQuery=new OrdersListQuery(ordersListServiceDto);
		
		int listCnt=orderDao.selectOrdersListCnt(new OrdersListCntQuery(ordersListServiceDto));
		ordersListQuery.getPaging().setTotalRecordCount(listCnt);
		return orderDao.selectOrdersList(ordersListQuery);
	}

	@Override
	public List<OrderItem> getOrdersDetail(Integer orderId) {
		return orderItemDao.selectOrderItemListByOrderId(orderId);
	}

}
