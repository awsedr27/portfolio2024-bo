package com.portfolioBo.admin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class AdminRequest {
	
	@Getter
	@Setter
	public static class AdminLoginRequest {
    	@NotBlank(message = "userId cannot be blank")
		private String userId;
    	@NotBlank(message = "password cannot be blank")
		private String password;
	}

}
