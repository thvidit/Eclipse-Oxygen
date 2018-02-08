package com.football.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface FootballServiceDao {
	
	public Response getallmatches();
	
	public Response getmatches(@PathParam("param") String team);

}
