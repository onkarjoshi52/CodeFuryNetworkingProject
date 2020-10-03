package com.demo.dao;

import com.demo.bean.UserDetails;

public interface LoginDao {

	UserDetails authenticateUser(String uname, String pass);

}
