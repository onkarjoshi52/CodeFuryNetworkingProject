package com.demo.dao;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.bean.UserDetails;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement ugetbyname,ugetid;
	static {
		conn=DBUtil.getMyConnection();
		try {
			ugetbyname=conn.prepareStatement("select * from userdetails where uname=? and upass=?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public UserDetails authenticateUser(String uname, String pass) {
		try {
			ugetbyname.setString(1, uname);
			ugetbyname.setString(2, pass);
			ResultSet rs=ugetbyname.executeQuery();
			if(rs.next()) {
				UserDetails u=new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				//System.out.println(u.getUname());
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