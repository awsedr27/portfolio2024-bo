package com.portfolioBo.order.dto;

import com.portfolioBo.common.Paging;
import com.portfolioBo.order.dto.OrderRequest.OrderItemsUpdateRequest;
import com.portfolioBo.order.dto.OrderRequest.OrdersListRequest;

import lombok.Getter;
import lombok.Setter;

public class OrderServiceDto {
    @Getter
    @Setter
	public static class OrdersListServiceDto {
	    private Integer orderId;
	    private String userNickName;
	    private String status;
	    private Paging paging;
	    public OrdersListServiceDto() {
	    	
	    }
		public OrdersListServiceDto(OrdersListRequest request) {
			this.orderId=request.getOrderId();
			this.userNickName=request.getUserNickName();
			this.status=request.getStatus();
		}
	    
	}
    @Getter
    @Setter
	public static class OrderItemUpdateServiceDto {
    	private Integer orderItemId;
	    private String orderItemStatus;
	    public OrderItemUpdateServiceDto() {
	    	
	    }
		public OrderItemUpdateServiceDto(OrderItemsUpdateRequest request) {
			this.orderItemId=request.getOrderItemId();
			this.orderItemStatus=request.getOrderItemStatus();
		}
	    
	}
}
