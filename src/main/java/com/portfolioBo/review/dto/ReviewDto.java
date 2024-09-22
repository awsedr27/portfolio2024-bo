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
    private Integer orderItemId;  
    private String useYn;
    private Integer rating;
    private String comment;
    private String reply;
    private Timestamp createDate;
    private Timestamp modifyDate;
    
    @Getter
    @Setter
    public static class ReviewDetailResult {
        private Integer reviewId;  
        private String productName;
        private String userNickName;
        private String useYn;
        private Integer rating;
        private String comment;
        private String reply;
        private Timestamp createDate;
        private Timestamp modifyDate;
    } 
    
    @Getter
    @Setter
    public static class ReviewListQuery {
        public ReviewListQuery() {
        	
		}
        public ReviewListQuery(ReviewListServiceDto serviceDto) {
        	this.productName=serviceDto.getProductName();
        	this.userNickName=serviceDto.getUserNickName();
        	this.useYn=serviceDto.getUseYn();
        	this.replyYn=serviceDto.getReplyYn();
        	this.paging=serviceDto.getPaging();

		}
	    private String productName;
	    private String userNickName;
	    private String useYn;
	    private String replyYn;
        private Paging paging;
        
    }
    @Getter
    @Setter
    public static class ReviewListResult {
        private Integer reviewId;  
        private String productName;  
        private String userNickName;
        private String useYn;
        private Integer rating;
        private String comment;
        private String reply;
        private Timestamp createDate;
        private Timestamp modifyDate;
    }
    @Getter
    @Setter
    public static class ReviewListCntQuery {
        public ReviewListCntQuery() {
        	
		}
        public ReviewListCntQuery(ReviewListServiceDto serviceDto) {
        	this.productName=serviceDto.getProductName();
        	this.userNickName=serviceDto.getUserNickName();
        	this.useYn=serviceDto.getUseYn();
        	this.replyYn=serviceDto.getReplyYn();
		}
	    private String productName;
	    private String userNickName;
	    private String useYn;
	    private String replyYn;
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
