package com.portfolioBo.review.dto;

import java.sql.Timestamp;

import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.review.dto.ReviewRequest.ReviewUpdateRequest;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewListServiceDto;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewUpdateServiceDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReviewDto {
	
    private Integer reviewId;  
    private Integer productId;  
    private String userId;
    private String useYn;
    private Integer rating;
    private String comment;
    private String reply;
    private Timestamp createDate;
    private Timestamp modifyDate;
    
    @Getter
    @Setter
    public static class ReviewListQuery {
        public ReviewListQuery() {
        	
		}
        public ReviewListQuery(ReviewListServiceDto serviceDto) {
        	this.reviewId=serviceDto.getReviewId();
        	this.productId=serviceDto.getProductId();
        	this.userId=serviceDto.getUserId();
        	this.useYn=serviceDto.getUseYn();
        	this.paging=serviceDto.getPaging();

		}
	    private Integer reviewId;  
	    private Integer productId;  
	    private String userId;
	    private String useYn;
        private Paging paging;
        
    }
    @Getter
    @Setter
    public static class ReviewListCntQuery {
        public ReviewListCntQuery() {
        	
		}
        public ReviewListCntQuery(ReviewListServiceDto serviceDto) {
        	this.reviewId=serviceDto.getReviewId();
        	this.productId=serviceDto.getProductId();
        	this.userId=serviceDto.getUserId();
        	this.useYn=serviceDto.getUseYn();
		}
	    private Integer reviewId;  
	    private Integer productId;  
	    private String userId;
	    private String useYn;  
    }
    @Getter
    @Setter
    public static class ReviewUpdateQuery {
        public ReviewUpdateQuery() {
        	
		}
        public ReviewUpdateQuery(ReviewUpdateServiceDto reviewUpdateServiceDto) {
        	this.reviewId=reviewUpdateServiceDto.getReviewId();
        	this.reply=reviewUpdateServiceDto.getReply();
			this.useYn = reviewUpdateServiceDto.getUseYn();

		}
    	private Integer reviewId;
        private String reply;
        private String useYn;    
    }
    
}
