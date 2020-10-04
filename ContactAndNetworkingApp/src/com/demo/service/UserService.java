package com.demo.service;

import java.util.List;

import com.demo.bean.UserDetails;

public interface UserService {

	List<UserDetails> getAllUsers();

	UserDetails searchUserByEmail(String cemail);

}
