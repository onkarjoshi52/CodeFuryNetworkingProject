package com.demo.dao;

import com.demo.bean.Contact;

public interface ContactDao {

	boolean checkIfExists(String cemail);

	int addNewContact(Contact contact);

}
