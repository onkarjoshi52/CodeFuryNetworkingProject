package com.demo.service;

import java.util.List;

import com.demo.bean.UserDetails;
import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}
	
	@Override
	public List<UserDetails> getAllUsers() {

		return userDao.getAllUsers();
	}

	@Override
	public UserDetails searchUserByEmail(String cemail) {
		
		return userDao.searchUserByEmail(cemail);
	}

}
