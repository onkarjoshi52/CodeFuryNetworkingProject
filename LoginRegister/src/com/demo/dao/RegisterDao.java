package com.demo.dao;

import java.awt.image.BufferedImage;

import java.sql.Blob;

import com.demo.bean.UserDetails;

public interface RegisterDao {

	boolean saveDetails(UserDetails userDetails) ;
	
	public Blob convertToBlob(BufferedImage bImage);
	
	public UserDetails checkUID(int uid);

}
