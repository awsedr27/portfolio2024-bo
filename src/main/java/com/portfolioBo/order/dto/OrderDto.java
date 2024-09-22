package com.portfolioBo.order.dto;

import java.sql.Timestamp;
import java.util.List;

import com.portfolioBo.common.Paging;
import com.portfolioBo.order.dto.OrderDto.OrderItemListResult;
import com.portfolioBo.order.dto.OrderServiceDto.OrderItemCancelServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrderUpdateServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrdersListServiceDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Integer orderId;
    private String userId;
    private Integer totalPrice;
    private String status;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private String postcode;
    private String roadAddress;
    private String jibunAddress;
    private String detailAddress;
    
    @Getter
    @Setter
    public static class OrderItemDto {
    	private Integer orderItemId;
    	private Integer orderId;
    	private Integer productId;
    	private Integer quantity;
    	private Integer price;
	    private String status;
	    private Timestamp createDate; 
	    private Timestamp modifyDate;
    }   
    @Getter
    @Setter
    public static class OrdersListQuery {
        public OrdersListQuery() {
        	
		}
        public OrdersListQuery(OrdersListServiceDto ordersListServiceDto) {
			this.orderId = ordersListServiceDto.getOrderId();
			this.userNickName = ordersListServiceDto.getUserNickName();
			this.status = ordersListServiceDto.getStatus();
			this.paging=ordersListServiceDto.getPaging();
		}
        private Integer orderId;
        private String userNickName;
        private String status;
        private Paging paging;
        
    }
    @Getter
    @Setter
    public static class OrdersListResult {
        private Integer orderId;
        private String userNickName;
        private Integer totalPrice;
        private String status;
        private Timestamp createDate;        
    }
    
    @Getter
    @Setter
    public static class OrdersListCntQuery {
        public OrdersListCntQuery() {
        	
		}
        public OrdersListCntQuery(OrdersListServiceDto ordersListServiceDto) {
			this.orderId = ordersListServiceDto.getOrderId();
			this.userNickName = ordersListServiceDto.getUserNickName();
			this.status = ordersListServiceDto.getStatus();
		}
        private Integer orderId;
        private String userNickName;
        private String status;
        
    }
    @Getter
    @Setter
    public static class OrderItemListResult {
    	private Integer orderItemId;
    	private String imageUrl;
        private String productName;
        private Integer quantity;
        private Integer price;
        private Timestamp orderItemCreateDate;
        private String orderItemStatus;
    }
    @Getter
    @Setter
    public static class OrderDetailResult {
        private Integer orderId;
        private String userNickName;
        private Integer totalPrice;
        private String postcode;
        private String roadAddress;
        private String jibunAddress;
        private String detailAddress;
        private String status;
        private Timestamp createDate;  
    	List<OrderItemListResult> orderItemList;
    }
    @Getter
    @Setter
    public static class OrderItemUpdateQuery {
        public OrderItemUpdateQuery() {
        	
		}
        public OrderItemUpdateQuery(OrderItemCancelServiceDto serviceDto) {
        	this.orderItemId=serviceDto.getOrderItemId();
		}
    	private Integer orderItemId;
	    private String status;
    }
    @Getter
    @Setter
    public static class OrderUpdateQuery {
    	private Integer orderId;
        private String postcode;
        private String roadAddress;
        private String jibunAddress;
        private String detailAddress;
        private String status;
        public OrderUpdateQuery() {
        	
		}
		public OrderUpdateQuery(OrderUpdateServiceDto orderUpdateServiceDto) {
			this.orderId=orderUpdateServiceDto.getOrderId();
			this.postcode=orderUpdateServiceDto.getPostcode();
			this.roadAddress=orderUpdateServiceDto.getRoadAddress();
			this.jibunAddress=orderUpdateServiceDto.getJibunAddress();
			this.detailAddress=orderUpdateServiceDto.getDetailAddress();
			this.status=orderUpdateServiceDto.getStatus();
		}
        
    }
    @Getter
    @Setter
    public static class OrderItemsStatusUpdateByOrderIdQuery{
    	private Integer orderId;
        private String status;
        public OrderItemsStatusUpdateByOrderIdQuery(){
        	
        }
        public OrderItemsStatusUpdateByOrderIdQuery(OrderUpdateServiceDto service){
        	this.orderId=service.getOrderId();
        	this.status=service.getStatus();
        }
    }
}
