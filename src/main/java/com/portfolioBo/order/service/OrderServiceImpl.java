package com.portfolioBo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.common.CommonEnum;
import com.portfolioBo.exception.CustomException;
import com.portfolioBo.order.dao.OrderDao;
import com.portfolioBo.order.dao.OrderItemDao;
import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrderDetailResult;
import com.portfolioBo.order.dto.OrderDto.OrderItemDto;
import com.portfolioBo.order.dto.OrderDto.OrderItemUpdateQuery;
import com.portfolioBo.order.dto.OrderDto.OrderItemsStatusUpdateByOrderIdQuery;
import com.portfolioBo.order.dto.OrderDto.OrderUpdateQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListCntQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListQuery;
import com.portfolioBo.order.dto.OrderDto.OrdersListResult;
import com.portfolioBo.order.dto.OrderServiceDto.OrderItemCancelServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrderUpdateServiceDto;
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
	public int cancelOrderItem(OrderItemCancelServiceDto orderItemCancelServiceDto) {
		OrderItemDto orderItemDto=orderItemDao.selectOrderItemWithExclusiveLock(orderItemCancelServiceDto.getOrderItemId());
		if(orderItemDto==null) {
			throw new CustomException("잘못된 주문 상품 번호입니다");
		}
		if(orderItemCancelServiceDto.getOrderId()!=orderItemDto.getOrderId()) {
			throw new CustomException("취소할려는 주문상품의 주문번호와 요청한 주문번호가 다릅니다");
		}
		if(CommonEnum.OrderItemStatus.CANCELLED.name().equals(orderItemDto.getStatus())||
				!CommonEnum.OrderItemStatus.PENDING.name().equals(orderItemDto.getStatus())) {
			throw new CustomException("취소할 수 없는 상태의 주문 상품입니다");
		}
		OrderItemUpdateQuery orderItemUpdateQuery=new OrderItemUpdateQuery(orderItemCancelServiceDto);
		orderItemUpdateQuery.setStatus(CommonEnum.OrderItemStatus.CANCELLED.name());
		int result=orderItemDao.updateOrderItem(orderItemUpdateQuery);
		List<OrderItemDto> orderItemList=orderItemDao.selectOrderItemListByOrderId(orderItemDto.getOrderId());
		 boolean allCancelled = orderItemList.stream()
			        .allMatch(orderItem -> CommonEnum.OrderItemStatus.CANCELLED.name().equals(orderItem.getStatus()));
		 if(allCancelled) {
			 OrderUpdateQuery orderUpdateQuery=new OrderUpdateQuery();
			 orderUpdateQuery.setOrderId(orderItemDto.getOrderId());
			 orderUpdateQuery.setStatus(CommonEnum.OrderStatus.CANCELLED.name());
			 int orderUpdateResult=orderDao.updateOrder(orderUpdateQuery);
		 }
		
		return result;
	}

	@Override
	public int updateOrder(OrderUpdateServiceDto orderUpdateServiceDto) {
		 OrderUpdateQuery orderUpdateQuery=new OrderUpdateQuery(orderUpdateServiceDto);
		 OrderDto order=orderDao.selectOrderWithExclusiveLock(orderUpdateQuery.getOrderId());
		 if(order==null) {
			 throw new CustomException("잘못된 주문 번호입니다");
		 }
		 if(CommonEnum.OrderStatus.CANCELLED.name().equals(order.getStatus())) {
			 throw new CustomException("이미 취소된 주문은 수정할 수 없습니다");
		 }
		 if(CommonEnum.OrderStatus.COMPLETED.name().equals(order.getStatus())) {
			 throw new CustomException("이미 완료된 주문은 수정할 수 없습니다");
		 }
		 int result=orderDao.updateOrder(orderUpdateQuery);
		 orderItemDao.updateOrderItemsStatusByOrderId(new OrderItemsStatusUpdateByOrderIdQuery(orderUpdateServiceDto));
		 
		return result;
	}


}
