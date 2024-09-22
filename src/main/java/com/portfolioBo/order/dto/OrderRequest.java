package com.portfolioBo.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class OrderRequest {
	
    @Getter
    @Setter
	public static class OrdersListRequest {
	    private Integer orderId;
	    private String userNickName;
	    private String status;
	    private int page;
	}
    @Getter
    @Setter
	public static class OrderItemsUpdateRequest {
        @NotNull(message = "orderId cannot be null")
        @Min(value = 1, message = "orderId must be greater than or equal to 1")
    	private Integer orderId;
        @NotNull(message = "orderItemId cannot be null")
        @Min(value = 1, message = "orderItemId must be greater than or equal to 1")
    	private Integer orderItemId;
        @NotBlank(message = "orderItemStatus cannot be blank")
        @Pattern(
                regexp = "PENDING|PROCESSING|SHIPPED|COMPLETED|CANCELLED|",
                message = "Invalid order status"
            )
	    private String orderItemStatus;
	}
}
