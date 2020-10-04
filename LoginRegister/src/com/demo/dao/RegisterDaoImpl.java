package com.demo.dao;

import java.time.Instant;  
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.util.Base64;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import com.demo.bean.UserDetails;

public class RegisterDaoImpl implements RegisterDao {

	static Connection conn;
	static PreparedStatement uregister,ugetid;
	static {
		conn=DBUtil.getMyConnection();
		try {
			uregister=conn.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ugetid=conn.prepareStatement("select uid from userdetails where uid=?");
		}catch(SQLException e) {
			
		}
		
}
	public Blob convertToBlob(BufferedImage bImage) {
		
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 Blob blob = null;
	      try {
			ImageIO.write(bImage, "jpg", bos );
			byte[] data = bos.toByteArray();
			blob = new SerialBlob(data);
			return blob;
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		return null;
	}
	
	public UserDetails checkUID(int uid) {
			ResultSet rs;
			try {
				ugetid.setInt(1, uid);
				rs = ugetid.executeQuery();
				if(rs.next()) {
					UserDetails u=new UserDetails(rs.getInt(1));
					return u;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
	}
	

	
	
	
	public boolean saveDetails(UserDetails userDetails) {
		
		Blob blob=convertToBlob(userDetails.getUimage());
		try {
			uregister.setString(1, userDetails.getUemail());
			uregister.setString(2, userDetails.getUname());
			uregister.setString(3, userDetails.getUfullName());
			uregister.setString(4, userDetails.getUpass());
			uregister.setString(5, userDetails.getUmob());
			uregister.setString(6, userDetails.getUgender());
			uregister.setDate(7,userDetails.getUbdate());
			uregister.setString(8, userDetails.getUaddress());
			uregister.setString(9, userDetails.getUcity());
			uregister.setString(10, userDetails.getUstate());
			uregister.setString(11, userDetails.getUcountry());
			uregister.setString(12, userDetails.getUcompany());
			uregister.setBlob(13, blob);
			uregister.setInt(14, userDetails.getUid());
			uregister.setString(15, userDetails.getSupportQn());
			uregister.setString(16, userDetails.getSupportAns());
			
			int rs=uregister.executeUpdate();
			if(rs!=0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}