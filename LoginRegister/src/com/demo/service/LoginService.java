package com.demo.service;

import com.demo.bean.UserDetails;

public interface LoginService {

	UserDetails validateUser(String uname, String pass);

}
