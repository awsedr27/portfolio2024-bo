package com.portfolioBo.order.service;

import java.util.List;

import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrderItem;
import com.portfolioBo.order.dto.OrderServiceDto.OrdersListServiceDto;

public interface OrderService {

	List<OrderDto> getOrdersList(OrdersListServiceDto ordersListServiceDto);

	List<OrderItem> getOrdersDetail(Integer orderId);

}
