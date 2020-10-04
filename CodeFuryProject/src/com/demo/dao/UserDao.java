package com.demo.dao;

import java.util.List;

import com.demo.bean.User;

//interface to implement Data-access layer functions
public interface UserDao {

	List<User> getListByName(String name);

	List<User> getListByCity(String city);

	List<User> getListByCompany(String company);

	int addFriendToList(int uid);

	int addUserToBlockList(int uid);

	List<User> getBlockByUser();

	int unBlockUser(String uemail);

}
