package com.demo.service;

import java.util.List;

import com.demo.bean.User;

//interface to implement all functions of business logic layer
public interface UserService {

	List<User> searchByName(String name);

	List<User> searchByCity(String city);

	List<User> searchByCompany(String company);

	int addToFriend(int uid);

	int addToBlockList(int uid);

	List<User> viewBlockedUserList();

	int removeFromBlockList(String uemail);

}
