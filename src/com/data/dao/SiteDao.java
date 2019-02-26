package com.data.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.model.Site;

public class SiteDao extends GenericDao {
	
	private static String SQL_GET_SITE = "SELECT sid\n"
			+ ",sname\n"
			+ "FROM site\n";
	
	
	public SiteDao() {
		super();
	}
	
	public static List<Site> getSites() {
		List<Site> sites = new ArrayList<>();
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");  
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/campaign_mgmt","root","password");  
			
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_GET_SITE);
			
			while(rs.next()) {
				Site site = new Site();
				site.setSid(rs.getInt(1));
				site.setSname(rs.getString(2));
				
				sites.add(site);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return sites;
	}

}
