package com.portfolioBo.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.admin.dao.AdminDao;
import com.portfolioBo.admin.dto.AdminDto;
import com.portfolioBo.admin.dto.AdminDto.AdminLoginQuery;
import com.portfolioBo.admin.dto.AdminServiceDto.AdminLoginServiceDto;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public AdminDto login(AdminLoginServiceDto adminLoginServiceDto) {
		AdminLoginQuery adminLoginQuery=new AdminLoginQuery(adminLoginServiceDto);
		AdminDto admin= adminDao.selectAdmin(adminLoginQuery);
		return admin;
	}

}
