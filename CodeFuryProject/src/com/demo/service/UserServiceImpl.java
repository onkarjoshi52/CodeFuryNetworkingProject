package com.demo.service;

import java.util.List;

import com.demo.bean.User;
import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImpl;

//business layer functions
public class UserServiceImpl implements UserService {
	private UserDao userdao;
	
	//constructor to initialize the value of data-access layer object
	public UserServiceImpl() {
		super();
		userdao = new UserDaoImpl();
	}
	
	//method to access data-access layer to return list of user according to name passed
	@Override
	public List<User> searchByName(String name) {
		return userdao.getListByName(name);
	}
	
	//method to access data-access layer to return list of user according to city passed
	@Override
	public List<User> searchByCity(String city) {
		return userdao.getListByCity(city);
	}
	
	//method to access data-access layer to return list of user according to company passed
	@Override
	public List<User> searchByCompany(String company) {
		return userdao.getListByCompany(company);
	}
	
	//method to access data-access layer to send friend request according to uid passed
	@Override
	public int addToFriend(int uid) {
		return userdao.addFriendToList(uid);
	}
	
	//method to access data-access layer to block user according to uid passed
	@Override
	public int addToBlockList(int uid) {
		return userdao.addUserToBlockList(uid);
	}
	
	//method to access data-access layer to view entire list of blocked user
	@Override
	public List<User> viewBlockedUserList() {
		return userdao.getBlockByUser();
	}
	
	//method to access data-access layer to unblock a user acccording to email sent
	@Override
	public int removeFromBlockList(String uemail) {
		return userdao.unBlockUser(uemail);
	}
}
