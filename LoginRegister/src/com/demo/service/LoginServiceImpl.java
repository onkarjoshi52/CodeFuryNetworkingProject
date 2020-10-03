package com.demo.service;

import com.demo.bean.UserDetails;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	private 
      LoginDao loginDao;
	
	public LoginServiceImpl() {
		super();
		loginDao=new LoginDaoImpl();
	}

	@Override
	public UserDetails validateUser(String uname, String pass) {
		UserDetails user=loginDao.authenticateUser(uname,pass);
		if(user!=null) {
	
	    if(user.getUname().equals(uname) && user.getUpass().equals(pass)) {
	    	return user;
	    }
		}
		return null;
	}

}
