package com.demo.dao;

import java.util.List;

import com.demo.bean.UserDetails;

public interface UserDao {

	List<UserDetails> getAllUsers();

	UserDetails searchUserByEmail(String cemail);

}
