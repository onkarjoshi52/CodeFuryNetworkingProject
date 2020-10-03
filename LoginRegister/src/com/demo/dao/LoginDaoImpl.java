package com.demo.dao;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.bean.UserDetails;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement pgetbyname;
	static {
		conn=DBUtil.getMyConnection();
		try {
			pgetbyname=conn.prepareStatement("select * from userdetails where uname=? and upass=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public UserDetails authenticateUser(String uname, String pass) {
		try {
			pgetbyname.setString(1, uname);
			pgetbyname.setString(2, pass);
			ResultSet rs=pgetbyname.executeQuery();
			if(rs.next()) {
				UserDetails u=new UserDetails(rs.getString(1),rs.getString(2));
				if(u.getUname().equals(uname) && u.getUpass().equals(pass)) {
					return u;
			    }
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}