package com.portfolioBo.admin.dto;

import com.portfolioBo.admin.dto.AdminRequest.AdminLoginRequest;

import lombok.Getter;
import lombok.Setter;

public class AdminServiceDto {
	
	@Getter
	@Setter
	public static class AdminLoginServiceDto {
		private String userId;
		private String password;
		
	    public AdminLoginServiceDto() {
	    	
	    }
		public AdminLoginServiceDto(AdminLoginRequest request) {
			this.userId=request.getUserId();
			this.password=request.getPassword();
		}
	}
}
