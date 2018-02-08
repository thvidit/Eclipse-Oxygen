package com.football.service;

import java.io.IOException;
import java.util.ArrayList;
import sun.misc.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.football.model.Driver;
import com.football.pojo.Match;
import com.google.gson.Gson;

@Path("/WebService")
public class FootballService {

		@GET
		@Path("/getallmatches")
		@Produces("application/json")
		public Response getallmatches()
		{
			String feeds = null;
			Response r=null;
			try 
			{
				ArrayList<Match> matches = null;
				Driver driver = new Driver();
				matches = driver.getAllMatches();
				Gson gson = new Gson();
				System.out.println(gson.toJson(matches));
				feeds = gson.toJson(matches);
			}
		
			catch (Exception e)
			{
				System.out.println("Exception Error"); //Console 
			}
				return Response.status(200).entity(feeds).build();
			}
		
		@GET
		@Path("/match")
		@Produces("application/json")
		public String match()
		{
			String feeds = null;
			Response r=null;
			try 
			{
				ArrayList<Match> matches = null;
				Driver driver = new Driver();
				matches = driver.getAllMatches();
				Gson gson = new Gson();
				System.out.println(gson.toJson(matches));
				feeds = gson.toJson(matches);
			}
		
			catch (Exception e)
			{
				System.out.println("Exception Error"); //Console 
			}
				return feeds;
			}
		

		@GET
		@Path("/getmatches/{param}")
		//@Produces("application/json")
		public Response getmatches(@PathParam("param") String team)
		{
			String response = null;
			try 
			{
				ArrayList<Match> matches = null;
				Driver driver = new Driver();
				matches = driver.getMatches(team);
				Gson gson = new Gson();
				System.out.println(gson.toJson(matches));
				response = gson.toJson(matches);
			}
		
			catch (Exception e)
			{
				System.out.println("Exception Error"); //Console 
			}
				return Response.status(200).entity(response).build();
			}
		
		@POST
		@Path("/addmatch")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response addToDatabase(@QueryParam("first") String firstTeam, @QueryParam("second") String secondTeam, 
				@QueryParam("matchDate")String matchDate, @QueryParam("gfirst") int goalFirst, 
				@QueryParam("gsecond") int goalSecond) {
				String response = null;
				Response r = null;
				System.out.println(firstTeam + secondTeam + goalFirst + goalSecond);
				//http://localhost:6767/RestWebServiceFootballDatabase/rest/WebService/addmatch?first=goa&second=chennaiyan&matchDate=2013-02-15 12:30:00&gfirst=3&gsecond=1
				try //2013-02-12 04:30:00
				{	
					Driver driver = new Driver();
					driver.addToDatabase(firstTeam, secondTeam, matchDate, goalFirst, goalSecond);
					response ="Match Added to database!";
					r = Response.status(200).entity(response).build();
					return r;
				}
			
				catch (Exception e)
				{
					System.out.println("Exception Error"); //Console 
				}
				return null;
				
			} //73, 2017-12-13 10:55:32, 'Goa', 'Kerala Blasters', 1, 2
		
		@GET
		@Path("/delete/{id}")
		public Response delete(@PathParam("id") int matchId) {
			boolean flag;
			Response r= null;
			try 
			{
				Driver driver = new Driver();
				flag = driver.delete(matchId);
				if(flag) {
					r= Response.status(200).entity("Details deleted from the database!").build();
					return r;
				}
			}
		
			catch (Exception e)
			{
				System.out.println("Exception Error"); //Console 
				return null;
			}
			return null;
		}
		
		 private boolean isUserAuthenticated(String authString){
	         
		        String decodedAuth = "";
		        // Header is in the format "Basic 5tyc0uiDat4"
		        // We need to extract data before decoding it back to original string
		        String[] authParts = authString.split("\\s+");
		        String authInfo = authParts[1];
		        // Decode the data back to original string
		        byte[] bytes = null;
		        try {
		            bytes = new BASE64Decoder().decodeBuffer(authInfo);
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        decodedAuth = new String(bytes);
		        System.out.println(decodedAuth);
		         
		        /**
		         * here you include your logic to validate user authentication.
		         * it can be using ldap, or token exchange mechanism or your 
		         * custom authentication mechanism.
		         */
		        // your validation code goes here....
		         
		        return true;
		    }


}