package com.portfolioBo.user.dto;

import com.portfolioBo.common.Paging;
import com.portfolioBo.user.dto.UserRequest.UserListRequest;
import com.portfolioBo.user.dto.UserRequest.UserUpdateRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class UserServiceDto {
    @Getter
    @Setter
	public static class UserListServiceDto {
	    private String userNickName;  
	    private String email;
	    private String useYn;
	    private Paging paging;
	    public UserListServiceDto() {
	    	
	    }
		public UserListServiceDto(UserListRequest request) {
			this.userNickName=request.getUserNickName();
			this.email=request.getEmail();
			this.useYn = request.getUseYn();
		}
	    
	}
    @Getter
    @Setter
	public static class UserUpdateServiceDto {
    	private String userId;
	    private String useYn;
	    public UserUpdateServiceDto() {
	    	
	    }
		public UserUpdateServiceDto(UserUpdateRequest request) {
			this.userId=request.getUserId();
			this.useYn = request.getUseYn();
		}
	    
	}
}
