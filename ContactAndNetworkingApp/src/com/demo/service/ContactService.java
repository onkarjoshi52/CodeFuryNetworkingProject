package com.demo.service;

import com.demo.bean.Contact;

public interface ContactService {

	boolean checkIfExists(String cemail);

	int addNewContact(Contact contact);

}
