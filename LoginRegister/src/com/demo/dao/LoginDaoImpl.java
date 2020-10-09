package com.demo.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import com.demo.bean.UserDetails;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement ugetbyname;
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
				Blob aBlob = rs.getBlob(13);
	            byte[] allBytesInBlob = aBlob.getBytes(1, (int) aBlob.length());
	            ByteArrayInputStream bais = new ByteArrayInputStream(allBytesInBlob);
	            BufferedImage bImage = ImageIO.read(bais);
				UserDetails u=new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),bImage,rs.getString(14),rs.getString(15),rs.getInt(16),rs.getBoolean(17));
				//System.out.println(u.getUname());
				if(u.getUname().equals(uname) && u.getUpass().equals(pass)) {
					return u;
			    }
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//UserDetails u=new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),(BufferedImage) rs.getArray(13),rs.getString(14),rs.getString(15),rs.getInt(16),rs.getBoolean(17));
}