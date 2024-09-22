package com.portfolioBo.order.dto;

import com.portfolioBo.common.Paging;
import com.portfolioBo.order.dto.OrderRequest.OrderItemsCancelRequest;
import com.portfolioBo.order.dto.OrderRequest.OrderUpdateRequest;
import com.portfolioBo.order.dto.OrderRequest.OrdersListRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	public static class OrderItemCancelServiceDto {
    	private Integer orderId;
    	private Integer orderItemId;
	    public OrderItemCancelServiceDto() {
	    	
	    }
		public OrderItemCancelServiceDto(OrderItemsCancelRequest request) {
			this.orderId=request.getOrderId();
			this.orderItemId=request.getOrderItemId();
		}
	    
	}
    @Getter
    @Setter
	public static class OrderUpdateServiceDto {
    	private Integer orderId;
        private String postcode;
        private String roadAddress;
        private String jibunAddress;
        private String detailAddress;
        private String status;
	    public OrderUpdateServiceDto() {
	    	
	    }
		public OrderUpdateServiceDto(OrderUpdateRequest request) {
			this.orderId=request.getOrderId();
			this.postcode=request.getPostcode();
			this.roadAddress=request.getRoadAddress();
			this.jibunAddress=request.getJibunAddress();
			this.detailAddress=request.getDetailAddress();
			this.status=request.getStatus();
		}
	    
	}
}
