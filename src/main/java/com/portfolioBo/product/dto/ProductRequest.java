package com.portfolioBo.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class ProductRequest {
	
    @Getter
    @Setter
	public static class ProductListRequest {
	    private Integer productId;  
	    private String name;
	    private String useYn;
	    private Integer price;
	    private Integer categoryId;
	    private int page;
	}
    
    @Getter
    @Setter
	public static class ProductSaveRequest {
    	@NotBlank(message = "Name cannot be blank")
        private String name;
        private String description;
        @NotNull(message = "UseYn cannot be null")
        @Pattern(regexp = "Y|N", message = "UseYn must be 'Y' or 'N'")
        private String useYn;
        @NotNull(message = "Price cannot be null")
        @Min(value = 0, message = "Price must be greater than or equal to 0")
        private Integer price;
        @NotNull(message = "categoryId cannot be null")
        @Min(value = 0, message = "categoryId must be greater than or equal to 0")
        private Integer categoryId;
	}
    
    @Getter
    @Setter
	public static class ProductUpdateRequest {
    	@NotNull(message = "productId cannot be null")
        @Min(value = 0, message = "productId must be greater than or equal to 0")
    	private Integer productId;
    	@NotBlank(message = "Name cannot be blank")
        private String name;
        private String description;
        @NotNull(message = "UseYn cannot be null")
        @Pattern(regexp = "Y|N", message = "UseYn must be 'Y' or 'N'")
        private String useYn;
        @NotNull(message = "Price cannot be null")
        @Min(value = 0, message = "Price must be greater than or equal to 0")
        private Integer price;
        @NotNull(message = "categoryId cannot be null")
        @Min(value = 0, message = "categoryId must be greater than or equal to 0")
        private Integer categoryId;
	}
}