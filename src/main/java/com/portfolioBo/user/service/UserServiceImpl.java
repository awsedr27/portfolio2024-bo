package com.portfolioBo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.exception.CustomException;
import com.portfolioBo.user.dao.UserDao;
import com.portfolioBo.user.dto.UserDto;
import com.portfolioBo.user.dto.UserDto.UserDetailResult;
import com.portfolioBo.user.dto.UserDto.UserListCntQuery;
import com.portfolioBo.user.dto.UserDto.UserListQuery;
import com.portfolioBo.user.dto.UserDto.UserListResult;
import com.portfolioBo.user.dto.UserDto.UserUpdateQuery;
import com.portfolioBo.user.dto.UserServiceDto.UserListServiceDto;
import com.portfolioBo.user.dto.UserServiceDto.UserUpdateServiceDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public List<UserListResult> getUserList(UserListServiceDto userListServiceDto) {
		UserListQuery userListQuery=new UserListQuery(userListServiceDto);
		int listCnt=userDao.selectUserListCnt(new UserListCntQuery(userListServiceDto));
		userListQuery.getPaging().setTotalRecordCount(listCnt);
		return userDao.selectUserList(userListQuery);
	}

	@Override
	public UserDetailResult getUserDetail(String userId) {
		return userDao.selectUserDetail(userId);
	}

	@Override
	public boolean updateUser(UserUpdateServiceDto userUpdateServiceDto) {
		UserUpdateQuery userUpdateQuery=new UserUpdateQuery(userUpdateServiceDto);
		UserDto user=userDao.selectUser(userUpdateServiceDto.getUserId());
		if(user==null) {
			throw new CustomException("잘못된 유저아이디입니다");
		}
		userDao.updateUser(userUpdateQuery);
		return true;
	}

}
