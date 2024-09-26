package com.portfolioBo.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.order.dto.OrderDto.OrderItemDto;
import com.portfolioBo.order.dto.OrderDto.OrderItemUpdateQuery;
import com.portfolioBo.order.dto.OrderDto.OrderItemsStatusUpdateByOrderIdQuery;

@Mapper
public interface OrderItemDao {

	int updateOrderItem(OrderItemUpdateQuery orderItemUpdateQuery);

	OrderItemDto selectOrderItemWithExclusiveLock(Integer orderItemId);
	
	List<OrderItemDto> selectOrderItemsWithExclusiveLockByOrderId(Integer orderId);
	
	List<OrderItemDto> selectOrderItemListByOrderId(Integer orderId);

	void updateOrderItemsStatusByOrderId(OrderItemsStatusUpdateByOrderIdQuery orderItemsStatusUpdateByOrderIdQuery);
}
