package com.demo.dao;

import java.util.List;

import com.demo.bean.ContactDetails;

import com.demo.bean.UserDetails;

public interface ContactDao {

	List<String> getUserEmail();

	List<String> getContactEmail();

	UserDetails getByUserEmail(String s);

	ContactDetails getByContactEmail(String p);

	void deleteContact(UserDetails u);

	void deleteContact(ContactDetails c);

	void updatecontact(UserDetails u);

	void updatecontact(ContactDetails c);

	ContactDetails getByCity(String city);

}
