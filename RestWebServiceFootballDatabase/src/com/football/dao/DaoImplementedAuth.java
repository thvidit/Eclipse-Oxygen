package com.football.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.football.pojo.Match;

@WebService(endpointInterface = "com.football.dao.DaoInterface")
public class DaoImplementedAuth implements DaoInterface {
	
	@Resource
	WebServiceContext context;

	@Override
	public ArrayList<Match> getAllMatches(Connection connection) throws Exception
	{
		ArrayList<Match> matches = new ArrayList<Match>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM matches");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Match match = new Match();
				match.setFirstTeamName(rs.getString("FIRST_TEAM_NAME"));
				match.setSecondTeamName(rs.getString("SECOND_TEAM_NAME"));
				match.setDate(rs.getTimestamp("MATCH_DATE"));
				match.setGoalsFirst(rs.getInt("FIRST_TEAM_GOALS"));
				match.setGoalsSecond(rs.getInt("SECOND_TEAM_GOALS"));
				matches.add(match);
			}
			return matches;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Override
	public ArrayList<Match> getMatches(String team,Connection connection) throws Exception
	{
		ArrayList<Match> matches = new ArrayList<Match>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM matches where First_team_name='" + team +"'");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Match match = new Match();
				match.setFirstTeamName(rs.getString("FIRST_TEAM_NAME"));
				match.setSecondTeamName(rs.getString("SECOND_TEAM_NAME"));
				match.setDate(rs.getTimestamp("MATCH_DATE"));
				match.setGoalsFirst(rs.getInt("FIRST_TEAM_GOALS"));
				match.setGoalsSecond(rs.getInt("SECOND_TEAM_GOALS"));
				matches.add(match);
			}
			return matches;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Override
	public void addToDatabase(String firstTeam, String secondTeam, String matchDate, int goalFirst, int goalSecond, Connection conn) {

		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into matches(MATCH_DATE,FIRST_TEAM_NAME,SECOND_TEAM_NAME,FIRST_TEAM_GOALS,SECOND_TEAM_GOALS) VALUES (" +"Timestamp " + 
							   "'" + matchDate + "', '" +  firstTeam + "', '" + secondTeam + "', '" + goalFirst +"', '" + goalSecond +"')" );  
			
			System.out.println("\n-------------- Match Details added to the database --------------");
			} catch(Exception e){
				e.printStackTrace();
			}
	}
	
	@Override
	public boolean delete(int matchId, Connection conn) {
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from matches where match_id= '" + matchId +"'" );  
			
			System.out.println("\n-------------- Match Details deleted from the database --------------");
			return true;
			} catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
	private boolean isAuthenticated() {
		MessageContext messageContext = context.getMessageContext();
		Map httpHeaders = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userNameList = (List) httpHeaders.get("uname");
		List passwordList = (List) httpHeaders.get("pass");

		if (userNameList.contains("thvidit") && passwordList.contains("thvidit"))
			return true;
		else
			return false;
	}

}
