package com.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.model.Site;

public class SiteDao extends GenericDao {
	
	private static String SQL_GET_SITE = "SELECT sid\n"
			+ ",sname\n"
			+ "FROM site\n";
	
	private static String SQL_GET_SITES = "select x.sid,s.sname \n" +
										  "from campaign_site_xref x \n" +
										  "join site s on x.sid=s.sid \n";
	
	private static String SQL_WHERE_CID = "WHERE cid = ?";
	
	public SiteDao() {
		super();
	}
	
	public static List<Site> getSites() {
		List<Site> sites = new ArrayList<>();
		
		try {	
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

	public static List<Site> getSitesforCampaign(int cid) {
	List<Site> sites = new ArrayList<>();
	PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement(SQL_GET_SITES + SQL_WHERE_CID);
		pstmt.setInt(1, cid);	
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Site site = new Site();
			site.setSid(rs.getInt(1));
			site.setSname(rs.getString(2));
			sites.add(site);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return sites;
}

}
