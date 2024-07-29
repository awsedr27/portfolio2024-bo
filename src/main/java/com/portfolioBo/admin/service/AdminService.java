package com.portfolioBo.admin.service;

import com.portfolioBo.admin.dto.AdminDto;
import com.portfolioBo.admin.dto.AdminServiceDto.AdminLoginServiceDto;

public interface AdminService {

	AdminDto login(AdminLoginServiceDto adminLoginServiceDto);

}
