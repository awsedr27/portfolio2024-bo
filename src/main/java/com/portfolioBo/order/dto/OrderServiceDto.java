package com.portfolioBo.order.dto;

import com.portfolioBo.common.Paging;
import com.portfolioBo.order.dto.OrderRequest.OrdersListRequest;

import lombok.Getter;
import lombok.Setter;

public class OrderServiceDto {
    @Getter
    @Setter
	public static class OrdersListServiceDto {
	    private Integer orderId;
	    private String userId;
	    private String status;
	    private Paging paging;
	    public OrdersListServiceDto() {
	    	
	    }
		public OrdersListServiceDto(OrdersListRequest request) {
			this.orderId=request.getOrderId();
			this.userId=request.getUserId();
			this.status=request.getStatus();
		}
	    
	}
}
