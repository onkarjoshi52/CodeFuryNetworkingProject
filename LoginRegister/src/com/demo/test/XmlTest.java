package com.demo.test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.Document;

import com.demo.bean.AdminDetails;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;

public class XmlTest {
	public static void main(String[] args) {
		AdminService a=new AdminServiceImpl();
		//String xmlString=a.getAdminDetails();
		AdminDetails ad=a.authenticateAdmin("admin", "admin123");
		System.out.println(ad.getAname());
		
}
}
