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
	public static class OrderItemsCancelRequest {
        @NotNull(message = "orderId cannot be null")
        @Min(value = 1, message = "orderId must be greater than or equal to 1")
    	private Integer orderId;
        @NotNull(message = "orderItemId cannot be null")
        @Min(value = 1, message = "orderItemId must be greater than or equal to 1")
    	private Integer orderItemId;
	}
    @Getter
    @Setter
	public static class OrderUpdateRequest {
        @NotNull(message = "orderId cannot be null")
        @Min(value = 1, message = "orderId must be greater than or equal to 1")
    	private Integer orderId;
        @NotBlank(message = "postcode cannot be blank")
        private String postcode;
        @NotBlank(message = "roadAddress cannot be blank")
        private String roadAddress;
        @NotBlank(message = "jibunAddress cannot be blank")
        private String jibunAddress;
        @NotBlank(message = "detailAddress cannot be blank")
        private String detailAddress;
        @NotBlank(message = "status cannot be null")
        @Pattern(
                regexp = "PENDING|PROCESSING|SHIPPED|COMPLETED|CANCELLED|",
                message = "Invalid order status"
            )
        private String status;
	}
}
