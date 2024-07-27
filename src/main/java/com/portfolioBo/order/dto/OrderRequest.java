package com.portfolioBo.order.dto;

import lombok.Getter;
import lombok.Setter;

public class OrderRequest {
	
    @Getter
    @Setter
	public static class OrdersListRequest {
	    private Integer orderId;
	    private String userId;
	    private String status;
	    private int page;
	}
}
