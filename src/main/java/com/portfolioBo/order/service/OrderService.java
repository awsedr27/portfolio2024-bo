package com.portfolioBo.order.service;

import java.util.List;

import com.portfolioBo.order.dto.OrderDto.OrderDetailResult;
import com.portfolioBo.order.dto.OrderDto.OrdersListResult;
import com.portfolioBo.order.dto.OrderServiceDto.OrderItemCancelServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrderUpdateServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrdersListServiceDto;

public interface OrderService {

	List<OrdersListResult> getOrdersList(OrdersListServiceDto ordersListServiceDto);

	OrderDetailResult getOrdersDetail(Integer orderId);

	int cancelOrderItem(OrderItemCancelServiceDto orderItemsUpdateServiceDto);

	int updateOrder(OrderUpdateServiceDto orderUpdateServiceDto);

}
