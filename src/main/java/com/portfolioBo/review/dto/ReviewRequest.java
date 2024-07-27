package com.portfolioBo.review.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class ReviewRequest {

    @Getter
    @Setter
	public static class ReviewListRequest {
	    private Integer reviewId;  
	    private Integer productId;  
	    private String userId;
	    private String useYn;
	    private int page;
	}
    @Getter
    @Setter
	public static class ReviewUpdateRequest {
    	@NotNull(message = "reviewId cannot be null")
        @Min(value = 0, message = "reviewId must be greater than or equal to 0")
    	private Integer reviewId;
        private String reply;
        @NotNull(message = "UseYn cannot be null")
        @Pattern(regexp = "Y|N", message = "UseYn must be 'Y' or 'N'")
        private String useYn;
	}
}
