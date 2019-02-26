package com.rest.service;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.data.dao.CampaignDao;
import com.data.model.Campaign;
import com.google.gson.Gson;

//@ApplicationPath("/")
@Path("/")
public class CampaignManagementService {

	@GET
	@Path("/site")
	@Produces("application/json")
	public String getSite() {	
		return "";
	}
	
	@GET
	@Path("/campaign")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getCampaigns() throws IOException {
		CampaignDao cdao = new CampaignDao();
		List<Campaign> campaigns = cdao.getCampaigns();
		 
		Gson gson = new Gson();
	    String jsonList = gson.toJson(campaigns);
	    System.out.println("jsonlist : " + jsonList);
		return Response.ok() //200
				.entity(jsonList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
		
	@DELETE
	@Path("/delete")
	@Produces("application/text")
	public Response deleteCampaign(@FormParam("id") int cid) {
		System.out.println("here "+cid);
		CampaignDao cdao = new CampaignDao();
		cdao.deleteCampaign(cid);
		return Response.ok() //200
				.entity(cid)
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
				.allow("OPTIONS").build();
	}

	@POST
	@Path("/campaign")
	@Produces("application/text")
	public Response insertCampaign(@FormParam("cname") String cname) {
		CampaignDao cdao = new CampaignDao();
		cdao.insertCampaign(cname);
		String test = "Pooja";
		return Response.ok() //200
				.entity(test)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
			//	String.format("%s was inserted", cname);
	}
	
		
		
		

	
}
