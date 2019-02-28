package com.data.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.data.model.Campaign;  

public class CampaignDao extends GenericDao {
	
	private static String SQL_GET_CAMPAIGN = "SELECT cid\n"
			+ ",cname\n"
			+ "FROM campaign\n";
	
	private static String SQL_DEL_CAMPAIGN = "DELETE FROM campaign\n";
	
	private static String SQL_WHERE_CID = "WHERE cid = ?";
	
	private static String SQL_INSERT_CAMPAIGN = "INSERT INTO campaign\n"
			+ "(cname) VALUES (?)";
	
	public CampaignDao() {
		super();
	}
	
	public static List<Campaign> getCampaigns() {
		List<Campaign> campaigns = new ArrayList<>();
		
		
		try {
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_GET_CAMPAIGN);
			
			while(rs.next()) {
				Campaign campaign = new Campaign();
				campaign.setCid(rs.getInt(1));
				campaign.setCname(rs.getString(2));
				
				campaigns.add(campaign);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		return campaigns;
	}
	
	public void deleteCampaign(int cid) {
		try {
			PreparedStatement stmt= con.prepareStatement(SQL_DEL_CAMPAIGN + SQL_WHERE_CID);
			stmt.setInt(1, cid);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void insertCampaign(String cname) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL_INSERT_CAMPAIGN);
			stmt.setString(1, cname);
			System.out.println("Insert Statement: " + stmt.toString());
			stmt.executeUpdate();
		}catch (Exception e) {
			e.getMessage();
		}
	}
}  

