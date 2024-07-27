package com.portfolioBo.order.dto;

import java.sql.Timestamp;

import com.portfolioBo.common.Paging;
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
    
    @Getter
    @Setter
    public static class OrdersListQuery {
        public OrdersListQuery() {
        	
		}
        public OrdersListQuery(OrdersListServiceDto ordersListServiceDto) {
			this.orderId = ordersListServiceDto.getOrderId();
			this.userId = ordersListServiceDto.getUserId();
			this.status = ordersListServiceDto.getStatus();
			this.paging=ordersListServiceDto.getPaging();
		}
        private Integer orderId;
        private String userId;
        private String status;
        private Paging paging;
        
    }
    @Getter
    @Setter
    public static class OrdersListCntQuery {
        public OrdersListCntQuery() {
        	
		}
        public OrdersListCntQuery(OrdersListServiceDto ordersListServiceDto) {
			this.orderId = ordersListServiceDto.getOrderId();
			this.userId = ordersListServiceDto.getUserId();
			this.status = ordersListServiceDto.getStatus();
		}
        private Integer orderId;
        private String userId;
        private String status;
        
    }
    @Getter
    @Setter
    public static class OrderItem {
    	private Integer orderItemId;
        private Integer orderId;
        private Integer productId;
        private Integer quantity;
        private Integer price;
        private Timestamp createDate;
        private Timestamp modifyDate;
    }
}
