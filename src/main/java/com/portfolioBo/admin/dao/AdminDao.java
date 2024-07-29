package com.portfolioBo.admin.dao;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.admin.dto.AdminDto;
import com.portfolioBo.admin.dto.AdminDto.AdminLoginQuery;

@Mapper
public interface AdminDao {

	AdminDto selectAdmin(AdminLoginQuery adminLoginQuery);

}
