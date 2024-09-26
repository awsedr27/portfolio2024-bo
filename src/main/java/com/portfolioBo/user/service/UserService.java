package com.portfolioBo.user.service;

import java.util.List;

import com.portfolioBo.user.dto.UserDto.UserDetailResult;
import com.portfolioBo.user.dto.UserDto.UserListResult;
import com.portfolioBo.user.dto.UserServiceDto.UserListServiceDto;
import com.portfolioBo.user.dto.UserServiceDto.UserUpdateServiceDto;

public interface UserService {

	List<UserListResult> getUserList(UserListServiceDto userListServiceDto);

	UserDetailResult getUserDetail(String userId);

	boolean updateUser(UserUpdateServiceDto userUpdateServiceDto);

}
