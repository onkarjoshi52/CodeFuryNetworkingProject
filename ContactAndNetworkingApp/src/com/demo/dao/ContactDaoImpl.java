package com.demo.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Contact;
import com.demo.bean.UserDetails;

public class ContactDaoImpl implements ContactDao {

	static Connection conn;
	static PreparedStatement pinsnewcontact;
	
	static {
		if(conn==null) {
			conn=DBUtil.getMyConnection();
		}
		try {
			pinsnewcontact=conn.prepareStatement("insert into contactdetails values(?,?,?,?,?,?,?,?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkIfExists(String cemail) {
		
		UserDao userDao=new UserDaoImpl();
		UserDetails user=userDao.searchUserByEmail(cemail);
		if(user!=null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int addNewContact(Contact contact) {
		final Blob blob = null;
		try {
			pinsnewcontact.setString(1, contact.getCemail());
			pinsnewcontact.setString(2, contact.getCfullName());
			pinsnewcontact.setString(3, contact.getCmob());
			pinsnewcontact.setString(4, contact.getCgender());
			pinsnewcontact.setDate(5, null);
			pinsnewcontact.setString(6, contact.getCaddress());
			pinsnewcontact.setString(7, contact.getCcity());
			pinsnewcontact.setString(8, contact.getCstate());
			pinsnewcontact.setString(9, contact.getCcountry());
			pinsnewcontact.setString(10, contact.getCcompany());
			pinsnewcontact.setBlob(11, blob);
			return pinsnewcontact.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
