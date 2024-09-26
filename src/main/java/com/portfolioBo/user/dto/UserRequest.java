package com.portfolioBo.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Getter
    @Setter
	public static class UserListRequest {
	    private String userNickName;  
	    private String email;
	    private String useYn;
	    private int page;
	}
    @Getter
    @Setter
	public static class UserUpdateRequest {
    	@NotBlank(message = "userId not blank")
    	private String userId;
    	@NotBlank(message = "UseYn cannot be null")
        @Pattern(regexp = "Y|N", message = "UseYn must be 'Y' or 'N'")
	    private String useYn;
	}
}
