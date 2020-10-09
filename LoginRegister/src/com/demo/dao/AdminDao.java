package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public interface AdminDao {
	public Document toDocument(ResultSet rs) throws ParserConfigurationException, SQLException ;
	
	public String getAdminDetails();

	public String getStringFromDoc(org.w3c.dom.Document doc);

	
}
