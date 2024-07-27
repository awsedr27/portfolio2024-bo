package com.portfolioBo.review.dto;

import com.portfolioBo.common.Paging;
import com.portfolioBo.review.dto.ReviewRequest.ReviewListRequest;
import com.portfolioBo.review.dto.ReviewRequest.ReviewUpdateRequest;

import lombok.Getter;
import lombok.Setter;

public class ReviewServiceDto {

	   @Getter
	    @Setter
		public static class ReviewListServiceDto {
		    private Integer reviewId;  
		    private Integer productId;  
		    private String userId;
		    private String useYn;
		    private Paging paging;
		    public ReviewListServiceDto() {
		    	
		    }
			public ReviewListServiceDto(ReviewListRequest request) {
				this.reviewId = request.getReviewId();
				this.productId = request.getProductId();
				this.userId = request.getUserId();
				this.useYn = request.getUseYn();
			}
		    
		}
	   
	    @Getter
	    @Setter
		public static class ReviewUpdateServiceDto {
	    	private Integer reviewId;
	        private String reply;
	        private String useYn;
		    public ReviewUpdateServiceDto() {
		    	
		    }
			public ReviewUpdateServiceDto(ReviewUpdateRequest request) {
				this.reviewId=request.getReviewId();
				this.reply=request.getReply();
				this.useYn=request.getUseYn();
			}
		    
		}
}
