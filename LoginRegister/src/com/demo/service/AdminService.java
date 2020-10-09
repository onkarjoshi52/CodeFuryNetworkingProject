package com.demo.service;

import java.util.List;

import org.w3c.dom.Document;

import com.demo.bean.AdminDetails;

public interface AdminService {
	public String getAdminDetails() ;
	
	public List<AdminDetails> getDetailsFromXml();
	
	public AdminDetails authenticateAdmin(String aname,String apass);
	
}
