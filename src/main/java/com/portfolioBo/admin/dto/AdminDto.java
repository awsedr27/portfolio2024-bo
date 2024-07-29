package com.portfolioBo.admin.dto;

import java.sql.Timestamp;

import com.portfolioBo.admin.dto.AdminServiceDto.AdminLoginServiceDto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AdminDto {
	private String userId;
	private String userName;
	private String password;
	private String useYn;
    private Timestamp createDate;
    private Timestamp modifyDate;
	

	@Getter
	@Setter
	public static class AdminLoginQuery {
		private String userId;
		private String password;
		
	    public AdminLoginQuery() {
	    	
	    }
		public AdminLoginQuery(AdminLoginServiceDto request) {
			this.userId=request.getUserId();
			this.password=request.getPassword();
		}
	}
}
