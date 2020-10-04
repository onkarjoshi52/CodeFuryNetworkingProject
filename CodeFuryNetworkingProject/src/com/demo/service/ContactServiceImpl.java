package com.demo.service;

import java.util.List;

import com.demo.bean.ContactDetails;

import com.demo.bean.UserDetails;
import com.demo.dao.ContactDao;
import com.demo.dao.ContactDaoImpl;


public class ContactServiceImpl implements ContactService {
	
     private ContactDao contactDao;
	
	public ContactServiceImpl() {
		super();
		contactDao=new ContactDaoImpl();
	}

	@Override
	public List<String> getUserEmail() {
		// TODO Auto-generated method stub
		return contactDao.getUserEmail();
	}

	@Override
	public List<String> getContactEmail() {
		// TODO Auto-generated method stub
		return contactDao.getContactEmail();
	}

	@Override
	public UserDetails getByUserEmail(String s) {
		// TODO Auto-generated method stub
		return contactDao.getByUserEmail(s);
	}

	@Override
	public ContactDetails getByContactEmail(String p) {
		// TODO Auto-generated method stub
		return contactDao.getByContactEmail(p);
	}

	@Override
	public void deleteContact(UserDetails u) {
		// TODO Auto-generated method stub
		  contactDao.deleteContact(u);
	}

	@Override
	public void deleteContact(ContactDetails c) {
		// TODO Auto-generated method stub
		contactDao.deleteContact(c);
		
	}

	@Override
	public void updatecontact(UserDetails u) {
		// TODO Auto-generated method stub
		contactDao.updatecontact(u);
		
	}

	@Override
	public void updatecontact(ContactDetails c) {
		// TODO Auto-generated method stub
		contactDao.updatecontact(c);
	}

	@Override
	public ContactDetails searchBycity(String city) {
		// TODO Auto-generated method stub
		return contactDao.getByCity(city);
	}
	
	

}
