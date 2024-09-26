package com.portfolioBo.user.dto;

import java.sql.Timestamp;

import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.user.dto.UserServiceDto.UserListServiceDto;
import com.portfolioBo.user.dto.UserServiceDto.UserUpdateServiceDto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {
	private String userId;
	private String username;
	private String email;
	private String userNickName; 
	private String useYn;
	private String naverSnsId;
	private String gender;
	private String birthday;
	private String birthyear;
    private Timestamp createDate;
    private Timestamp modifyDate;
	
    @Getter
    @Setter
    public static class UserListQuery {
	    private String userNickName;  
	    private String email;
	    private String useYn;
        private Paging paging;
        public UserListQuery() {
        	
		}
        public UserListQuery(UserListServiceDto service) {
        	this.userNickName=service.getUserNickName();
        	this.email=service.getEmail();
        	this.useYn=service.getUseYn();
        	this.paging=service.getPaging();
		}
    }
    @Getter
    @Setter
    public static class UserListResult {
    	private String userId;
    	private String email;
    	private String userNickName;
        private String useYn;
        private Timestamp createDate;
    }
    
    @Getter
    @Setter
    public static class UserListCntQuery {
	    private String userNickName;  
	    private String email;
	    private String useYn;
        public UserListCntQuery() {
        	
		}
        public UserListCntQuery(UserListServiceDto service) {
        	this.userNickName=service.getUserNickName();
        	this.email=service.getEmail();
        	this.useYn=service.getUseYn();
		}
    }
    @Getter
    @Setter
    public static class UserDetailResult {
    	private String userId;
    	private String username;
    	private String email;
    	private String userNickName;  
    	private String useYn;
    	private String gender;
    	private String birthday;
    	private String birthyear;
        private Timestamp createDate;
    }
    @Getter
    @Setter
    public static class UserUpdateQuery {
    	private String userId;
	    private String useYn;
        public UserUpdateQuery() {
        	
		}
        public UserUpdateQuery(UserUpdateServiceDto service) {
        	this.userId=service.getUserId();
        	this.useYn=service.getUseYn();
		}
    }
}


