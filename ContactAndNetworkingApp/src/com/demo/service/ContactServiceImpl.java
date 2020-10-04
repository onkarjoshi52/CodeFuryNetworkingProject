package com.demo.service;

import com.demo.bean.Contact;
import com.demo.dao.ContactDao;
import com.demo.dao.ContactDaoImpl;

public class ContactServiceImpl implements ContactService {

	ContactDao contactDao;
	
	public ContactServiceImpl(){
		contactDao=new ContactDaoImpl();
	}
	
	@Override
	public boolean checkIfExists(String cemail) {
		return contactDao.checkIfExists(cemail);
		
	}

	@Override
	public int addNewContact(Contact contact) {
		return contactDao.addNewContact(contact);
	}

}
