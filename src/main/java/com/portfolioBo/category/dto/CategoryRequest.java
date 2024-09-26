package com.portfolioBo.category.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class CategoryRequest {
	
    @Getter
    @Setter
	public static class CategoryListRequest {
	    private Integer categoryId;  
	    private String name;
	    private String useYn;
	    private int page;
	}
    @Getter
    @Setter
	public static class CategorySaveRequest {
    	@NotBlank(message = "Name cannot be blank")
        private String name;
        private String description;
        @NotBlank(message = "UseYn cannot be null")
        @Pattern(regexp = "Y|N", message = "UseYn must be 'Y' or 'N'")
        private String useYn;
	}
    
    @Getter
    @Setter
	public static class CategoryUpdateRequest {
        @NotNull(message = "categoryId cannot be null")
        @Min(value = 0, message = "categoryId must be greater than or equal to 0")
        private Integer categoryId;
    	@NotBlank(message = "Name cannot be blank")
        private String name;
        private String description;
        @NotBlank(message = "UseYn cannot be null")
        @Pattern(regexp = "Y|N", message = "UseYn must be 'Y' or 'N'")
        private String useYn;
	}
}
