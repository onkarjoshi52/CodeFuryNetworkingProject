package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;



public class AdminDaoImpl implements AdminDao {

	static Connection conn;
	static PreparedStatement agetadmin;
	static Document doc =null;
	static {
		conn=DBUtil.getMyConnection();
		try {
			agetadmin=conn.prepareStatement("select * from admindetails");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//gets admindetails from database
	public String getAdminDetails() {
		ResultSet rs;
		try {
			rs = agetadmin.executeQuery();
			doc = toDocument(rs);
			String xmlStr=getStringFromDoc(doc);
			return xmlStr;
		} catch (SQLException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	
	//converts result set to document
	public Document toDocument(ResultSet rs) throws ParserConfigurationException, SQLException {
		   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		   DocumentBuilder builder        = factory.newDocumentBuilder();
		   Document doc                   = builder.newDocument();
		   Element results = (Element) doc.createElement("AdminDetails");
		   doc.appendChild((Node) results);
		   ResultSetMetaData rsmd = rs.getMetaData();
		   int colCount = rsmd.getColumnCount();
		   while (rs.next())
		   {
		      Element row = (Element) doc.createElement("Admin");
		      ((Node) results).appendChild((Node) row);
		      for (int i = 1; i <= colCount; i++)
		      {
		         String columnName = rsmd.getColumnName(i);
		         Object value = rs.getObject(i);
		         Element node = (Element) doc.createElement(columnName);
		         ((Node) node).appendChild(doc.createTextNode(value.toString()));
		         ((Node) row).appendChild((Node) node);
		      }
		   }
		   return doc;
		}
	
	
	//converts doc to string
	public String getStringFromDoc(org.w3c.dom.Document doc)  {
	    DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
	    LSSerializer lsSerializer = domImplementation.createLSSerializer();
	    return lsSerializer.writeToString(doc);   
	}
}
