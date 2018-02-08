package com.jira.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.jira.dao.MindsDaoImpl;
import com.jira.dao.MindsDaoInterface;
import com.jira.models.Capabilities;

@Path("/jira")
public class MindsServiceImpl implements MindsServiceDao{
	
	MindsDaoInterface minds = new MindsDaoImpl();

	@Override
	@GET
	@Produces("application/json")
	@Path("/capabilities")
	public Set<Capabilities> getCapabilites(@QueryParam("mid") String m_id) {
		Set<Capabilities> capabilities = minds.getCapabilities(m_id);
		Gson gson = new Gson();
		String capabilitiesJson = gson.toJson(capabilities);
		System.out.println("Capabilities json: " + capabilitiesJson);
		return capabilities;
	}

}
