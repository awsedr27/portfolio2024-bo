package com.portfolioBo.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.user.dto.UserDto;
import com.portfolioBo.user.dto.UserDto.UserDetailResult;
import com.portfolioBo.user.dto.UserDto.UserListCntQuery;
import com.portfolioBo.user.dto.UserDto.UserListQuery;
import com.portfolioBo.user.dto.UserDto.UserListResult;
import com.portfolioBo.user.dto.UserDto.UserUpdateQuery;

@Mapper
public interface UserDao {

	int selectUserListCnt(UserListCntQuery userListCntQuery);

	List<UserListResult> selectUserList(UserListQuery userListQuery);

	UserDetailResult selectUserDetail(String userId);

	UserDto selectUser(String userId);

	int updateUser(UserUpdateQuery userUpdateQuery);

}
