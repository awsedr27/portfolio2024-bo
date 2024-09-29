package com.portfolioBo.order.service;

import java.util.ArrayList;
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
import com.portfolioBo.product.dao.ProductDao;
import com.portfolioBo.product.dto.ProductDto.ProductUpdateQuantityQuery;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	ProductDao productDao;

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
		boolean orderItemIdCheckFlag=false;
		boolean orderCancelFlag=true;
		List<ProductUpdateQuantityQuery> productList=new ArrayList<ProductUpdateQuantityQuery>();
		OrderDto order=orderDao.selectOrderWithExclusiveLock(orderItemCancelServiceDto.getOrderId());
		if(order==null) {
			throw new CustomException("주문번호가 잘못됬습니다");
		}
		List<OrderItemDto> orderItems=orderItemDao.selectOrderItemsWithExclusiveLockByOrderId(orderItemCancelServiceDto.getOrderId());
		if(orderItems==null||orderItems.size()==0) {
			throw new CustomException("주문상품이 없습니다");
		}
		for(OrderItemDto orderItem:orderItems) {
			if(orderItem.getOrderItemId().equals(orderItemCancelServiceDto.getOrderItemId())) {
				//삭제요청한 주문상품인 경우
				if(!CommonEnum.OrderItemStatus.PENDING.name().equals(orderItem.getStatus())) {
					throw new CustomException("취소할 수 없는 상태입니다.");
				}
				orderItemIdCheckFlag=true;
				productList.add(new ProductUpdateQuantityQuery(orderItem.getProductId(),orderItem.getQuantity()));
			}else {
				//삭제요청한 주문상품이 아닌경우
				if(!CommonEnum.OrderItemStatus.CANCELLED.name().equals(orderItem.getStatus())) {
					orderCancelFlag=false;
				}
			}
		}
		if(!orderItemIdCheckFlag) {
			throw new CustomException("삭제 요청한 주문상품번호와 주문번호가 매칭이 안됩니다");
		}
        if(CommonEnum.OrderStatus.CANCELLED.name().equals(order.getStatus())) {
       	 throw new CustomException("취소된 주문은 수정할 수 없습니다");
        }
        if(CommonEnum.OrderStatus.COMPLETED.name().equals(order.getStatus())) {
       	 throw new CustomException("완료된 주문은 수정할 수 없습니다");
        }
		
		OrderItemUpdateQuery orderItemUpdateQuery =new OrderItemUpdateQuery();
		orderItemUpdateQuery.setOrderItemId(orderItemCancelServiceDto.getOrderItemId());
		orderItemUpdateQuery.setStatus(CommonEnum.OrderItemStatus.CANCELLED.name());
		orderItemDao.updateOrderItem(orderItemUpdateQuery);
		
		if(orderCancelFlag) {
			//주문상품이 전부 취소상태일 때 주문도 취소상태로 변경
			OrderUpdateQuery orderUpdateQuery=new OrderUpdateQuery();
			orderUpdateQuery.setOrderId(orderItemCancelServiceDto.getOrderId());
			orderUpdateQuery.setStatus(CommonEnum.OrderItemStatus.CANCELLED.name());
			orderDao.updateOrder(orderUpdateQuery);
		}
		return productDao.updateQuantitiesPlus(productList);
	}

	@Override
	public int updateOrder(OrderUpdateServiceDto orderUpdateServiceDto) {
		 OrderUpdateQuery orderUpdateQuery=new OrderUpdateQuery(orderUpdateServiceDto);
		 List<ProductUpdateQuantityQuery> productList=new ArrayList<ProductUpdateQuantityQuery>();

		 OrderDto order=orderDao.selectOrderWithExclusiveLock(orderUpdateServiceDto.getOrderId());
		 if(order==null) {
			 throw new CustomException("잘못된 주문 번호입니다");
		 }
		 List<OrderItemDto> orderItems=orderItemDao.selectOrderItemsWithExclusiveLockByOrderId(orderUpdateServiceDto.getOrderId());
		 if(orderItems==null||orderItems.size()==0) {
			 throw new CustomException("주문상품이 없습니다");
		 }
         if(CommonEnum.OrderStatus.CANCELLED.name().equals(order.getStatus())) {
        	 throw new CustomException("취소된 주문은 수정할 수 없습니다");
         }
         if(CommonEnum.OrderStatus.COMPLETED.name().equals(order.getStatus())) {
        	 throw new CustomException("완료된 주문은 수정할 수 없습니다");
         }
         //주문취소 요청 시 
		 if(CommonEnum.OrderStatus.CANCELLED.name().equals(orderUpdateServiceDto.getStatus())) {
			 
			if(!CommonEnum.OrderItemStatus.PENDING.name().equals(order.getStatus())) {
				throw new CustomException("주문을 취소할 수 있는 상태가 아닙니다");
			}
			for(OrderItemDto orderItem:orderItems) {
				productList.add(new ProductUpdateQuantityQuery(orderItem.getProductId(),orderItem.getQuantity()));
			}
			//취소에 따른 상품수량 원상복구
			productDao.updateQuantitiesPlus(productList);
		 }
		 int result=orderDao.updateOrder(orderUpdateQuery);
		 orderItemDao.updateOrderItemsStatusByOrderId(new OrderItemsStatusUpdateByOrderIdQuery(orderUpdateServiceDto));
		return result;
	}


}
