package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.demo.bean.ContactDetails;


import com.demo.bean.UserDetails;

public class ContactDaoImpl implements ContactDao{

	static Connection conn;
	static PreparedStatement cgetuemail,cgetcemail,cgetbyuseremail,cgetbycontactemail,cdeleteuser,cdeletecontact,cupdateuser,cupdatecontact,cbycity,pgetcat,pprogetbycat,pins,pgetbyid,pupdate,premove,pbyname,pgetall;
	static {
		conn=DBUtil.getMyConnection();
		try {
			cgetuemail=conn.prepareStatement("select uemail from contactlist ");
			cgetcemail=conn.prepareStatement("select cemail from contactlist ");
			cgetbyuseremail=conn.prepareStatement("select * from userdetails where uemail=? ");
			cgetbycontactemail=conn.prepareStatement("select * from contactdetails where cemail=? ");
			cdeleteuser=conn.prepareStatement("delete from contactlist where uemail=? ");
			cdeletecontact=conn.prepareStatement("delete from contactdetails where cemail=? ");
			cupdateuser=conn.prepareStatement("update userdetails set uname=?,umob=?,ucity=? where uemail=?");
			cupdatecontact=conn.prepareStatement("update contactdetails set cname=?,cmob=?,ccity=? where cemail=?");
			cbycity=conn.prepareStatement("select * from contactdetails where ccity=?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<String> getUserEmail() {
		// TODO Auto-generated method stub
		
		try {
			ResultSet rs=cgetuemail.executeQuery();
			List<String> cList=new ArrayList<>();
			while(rs.next())
			{
				
				cList.add(rs.getString(2));
			}
			return cList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return null;
	}

	@Override
	public List<String> getContactEmail() {
		// TODO Auto-generated method stub
		try {
			ResultSet rs=cgetcemail.executeQuery();
			List<String> cList=new ArrayList<>();
			while(rs.next())
			{
				
				cList.add(rs.getString(3));
			}
			return cList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return null;
	}

	@Override
	public UserDetails getByUserEmail(String s) {
		// TODO Auto-generated method stub
		try { 
			cgetbyuseremail.setString(1, s);
			ResultSet rs=cgetbyuseremail.executeQuery();
			List<UserDetails> pList=new ArrayList<>();
			UserDetails p=null;
			while(rs.next())
			{
			      p=new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return null;
	}

	@Override
	public ContactDetails getByContactEmail(String p) {
		// TODO Auto-generated method stub
		try { 
			cgetbycontactemail.setString(1, p);
			ResultSet rs=cgetbycontactemail.executeQuery();
			
			ContactDetails c=null;
			while(rs.next())
			{
				 c=new ContactDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return null;
	}

	@Override
	public void deleteContact(UserDetails u) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(p.getpId());   
			cdeleteuser.setString(1, u.getUemail());
			cdeleteuser.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteContact(ContactDetails c) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(p.getpId());   
			cdeletecontact.setString(1, c.getCemail());
			cdeletecontact.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatecontact(UserDetails u) {
		// TODO Auto-generated method stub
		try {
			cupdateuser.setString(1, u.getUemail());
			cupdateuser.setString(2, u.getUfullName());
			cupdateuser.setString(3, u.getUmob());
			cupdateuser.setString(4, u.getUcity());
			cupdateuser.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updatecontact(ContactDetails c) {
		// TODO Auto-generated method stub
		try {
			cupdatecontact.setString(1, c.getCemail());
			cupdatecontact.setString(2, c.getCfullName());
			cupdatecontact.setString(3, c.getCmob());
			cupdatecontact.setString(4, c.getCcity());
			
			cupdatecontact.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ContactDetails getByCity(String city) {
		// TODO Auto-generated method stub
		try {
			cbycity.setString(1, city);
             ResultSet rs=cbycity.executeQuery();
			
			ContactDetails c=null;
			while(rs.next())
			{
				 c=new ContactDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
