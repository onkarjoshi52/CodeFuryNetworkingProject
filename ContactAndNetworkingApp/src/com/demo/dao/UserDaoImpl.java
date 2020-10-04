package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.UserDetails;

public class UserDaoImpl implements UserDao {

	static Connection conn;
	static PreparedStatement pgetuser;
	
	static {
		conn=DBUtil.getMyConnection();
		try {
			pgetuser=conn.prepareStatement("select * from userdetails");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<UserDetails> getAllUsers() {
		
		try {
			ResultSet rs=pgetuser.executeQuery();
			List<UserDetails> ulist=new ArrayList<>();
			UserDetails user=null;
			while(rs.next()) {
				user=new UserDetails(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4) , rs.getString(5), rs.getString(6), null, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), null, 0, null, null);
				ulist.add(user);
			}
			return ulist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserDetails searchUserByEmail(String cemail) {
		
		List<UserDetails> ulist=getAllUsers();
		for(UserDetails u:ulist) {
			if(cemail.equals(u.getUemail())) {
				return u;
			}
		}
		return null;
	}

}
