package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton class for database connection
public class DBUtil {
	static Connection conn=null;
	public static Connection getMyConnection() {
		if(conn==null) {
			try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			//connect to database
			String url = "jdbc:derby:E:\\study\\HSBC\\Training\\mydata\\hsbcdb";
	        String user = "hsbc";
	        String password = "hsbc123";
	        
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
		           System.out.println("Connected to database ");
		    }
			} catch (SQLException e) {
				System.out.println("Connection not done derby ");
				e.printStackTrace();
			}
			
		}
		return conn;
	}
	
	//to close connection to database
	public static void closeMyConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
