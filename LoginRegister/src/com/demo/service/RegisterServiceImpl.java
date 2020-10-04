package com.demo.service;

import com.demo.bean.UserDetails;
import com.demo.dao.RegisterDao;
import com.demo.dao.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService {
	private RegisterDao registerDao;
	
	public  RegisterServiceImpl() {
		super();
		registerDao=new RegisterDaoImpl();
	}
	 public boolean saveDetails(UserDetails userDetails) {
		return registerDao.saveDetails(userDetails);
		 
		
	}
	@Override
	public UserDetails checkUiD(int uid) {
		return registerDao.checkUID(uid);
	}

}
