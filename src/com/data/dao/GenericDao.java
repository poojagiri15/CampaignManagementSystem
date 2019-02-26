package com.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class GenericDao {
	
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String CONN = "jdbc:mysql://localhost:3306/campaign_mgmt";
	private static String USER = "root";
	private static String PASS = "password";
	
	public static Connection con;
	
	public GenericDao() {
		if (null == con) {
			try {
				Class.forName(DRIVER);  
				con = DriverManager.getConnection(CONN, USER, PASS);
			} catch (Exception e) {
				System.out.println("Couldn't get database connection " + e.getMessage());
			}
			
		}
	}
	
	public void closeConnection(Connection con) throws Exception {
		con.close();
	}
}
