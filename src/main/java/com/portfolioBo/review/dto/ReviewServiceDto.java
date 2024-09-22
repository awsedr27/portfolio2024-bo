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
		    private String productName;
		    private String userNickName;
		    private String useYn;
		    private String replyYn;
		    private Paging paging;
		    public ReviewListServiceDto() {
		    	
		    }
			public ReviewListServiceDto(ReviewListRequest request) {
				this.productName=request.getProductName();
				this.userNickName=request.getUserNickName();
				this.useYn = request.getUseYn();
				this.replyYn=request.getReplyYn();
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
