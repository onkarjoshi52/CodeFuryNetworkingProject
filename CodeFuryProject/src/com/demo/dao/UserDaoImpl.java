package com.demo.dao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.demo.bean.User;

//data-access layer functions
public class UserDaoImpl implements UserDao {
	static Connection conn;
	static PreparedStatement ugetNameList, ugetCityList, ugetCompanyList, ugetById, uaddFriendSent, uaddFriendReceive, uaddToBlockList, ugetBlockList, utoUnblock;
	static {
		//database connection
		conn=DBUtil.getMyConnection();
		try {
			//queries for various functions
			ugetNameList = conn.prepareStatement("select * from userdetails where ufullname=? and uid not in(select uid from blockedbyfriendlist);");
			ugetCityList = conn.prepareStatement("select * from userdetails where ucity=? and uid not in(select uid from blockedbyfriendlist);");
			ugetCompanyList = conn.prepareStatement("select * from userdetails where ucompany=? and uid not in(select uid from blockedbyfriendlist);");
			ugetById = conn.prepareStatement("select * from userdetails where uid=?");
			uaddFriendSent = conn.prepareStatement("insert into friendrequestsend values(?,?)");
			uaddFriendReceive = conn.prepareStatement("insert into friendrequestreceive values(?,?)");
			uaddToBlockList = conn.prepareStatement("insert into blockedfriendlist values(?,?)");
			ugetBlockList = conn.prepareStatement("select * from blockedfriendlist");
			utoUnblock = conn.prepareStatement("delete from blockedfriendlist where uemail=?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// method to return a list containing user details of those users whose name is same as that passed by the service layer
	@Override
	public List<User> getListByName(String name) {
		try {
			ugetNameList.setString(1, name);
			ResultSet rs = ugetNameList.executeQuery();
			List<User> ulist = new ArrayList<>();
			while(rs.next()) {
				Blob blob = rs.getBlob(13);  
				InputStream in = blob.getBinaryStream();  
				BufferedImage uimage = null;
				try {
					uimage = ImageIO.read(in);
					User uObj = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), uimage, rs.getInt(14), rs.getString(15), rs.getString(16));
					System.out.println(uObj);
					ulist.add(uObj);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return ulist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// method to return a list containing user details of those users whose city is same as that passed by the service layer
	@Override
	public List<User> getListByCity(String city) {
		try {
			ugetCityList.setString(1, city);
			ResultSet rs = ugetCityList.executeQuery();
			List<User> ulist = new ArrayList<>();
			while(rs.next()) {
				Blob blob = rs.getBlob(13);  
				InputStream in = blob.getBinaryStream();  
				BufferedImage uimage = null;
				uimage = ImageIO.read(in);
				User uObj = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), uimage, rs.getInt(14), rs.getString(15), rs.getString(16));
				System.out.println(uObj);
				ulist.add(uObj);
			}
			return ulist;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// method to return a list containing user details of those users whose company is same as that passed by the service layer
	@Override
	public List<User> getListByCompany(String company) {
		try {
			ugetCompanyList.setString(1, company);
			ResultSet rs = ugetCompanyList.executeQuery();
			List<User> ulist = new ArrayList<>();
			while(rs.next()) {
				Blob blob = rs.getBlob(13);  
				InputStream in = blob.getBinaryStream();  
				BufferedImage uimage = null;
				uimage = ImageIO.read(in);
				User uObj = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), uimage, rs.getInt(14), rs.getString(15), rs.getString(16));
				System.out.println(uObj);
				ulist.add(uObj);
			}
			return ulist;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//method to return user object whose id is same as the id passed
	public User searchById(int uid) {
		try {
			ugetById.setInt(1, uid);
			ResultSet rs = ugetById.executeQuery();
			if(rs.next()) {
				Blob blob = rs.getBlob(13);  
				InputStream in = blob.getBinaryStream();  
				BufferedImage uimage = null;
				uimage = ImageIO.read(in);
				User uObj = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), uimage, rs.getInt(14), rs.getString(15), rs.getString(16));
				return uObj;
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//method to send a friend request to user whose id is passed
	@Override
	public int addFriendToList(int uid) {
		User uadd = searchById(uid);
		System.out.println("USER to add in dao : " + uadd);
		try {
			uaddFriendSent.setInt(1, uadd.getUid());	//instead of udd.getUid() we will take id from session object
			uaddFriendSent.setString(2, uadd.getUemail());
			int n = uaddFriendSent.executeUpdate();
			uaddFriendReceive.setInt(1, uadd.getUid());
			uaddFriendReceive.setString(2, uadd.getUemail()); 	//instead of udd.getUemail() we will take email from session object
			int m = uaddFriendReceive.executeUpdate();
			System.out.println("RETURN Status : " + (m+n));
			return (m+n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//method to block a user whose id is passed
	@Override
	public int addUserToBlockList(int uid) {
		User uadd = searchById(uid);
		System.out.println("USER to block in dao : " + uadd);
		try {
			uaddToBlockList.setInt(1, uadd.getUid());	
			uaddToBlockList.setString(2, uadd.getUemail());
			int n = uaddToBlockList.executeUpdate();
			System.out.println("RETURN Status : " + n);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//method that returns a list of users that have been blocked
	@Override
	public List<User> getBlockByUser() {
		try {
			ResultSet rs = ugetBlockList.executeQuery();
			List<User> ulist = new ArrayList<>();
			while(rs.next()) {
				User uObj = new User(rs.getInt(1), rs.getString(2));
				ulist.add(uObj);
			}
			return ulist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//method to unblock a user
	@Override
	public int unBlockUser(String uemail) {
		try {
			utoUnblock.setString(1, uemail);
			int n = utoUnblock.executeUpdate();
			System.out.println("RETURN Status : " + n);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
