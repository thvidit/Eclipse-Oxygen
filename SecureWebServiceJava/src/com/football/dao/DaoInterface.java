package com.football.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.football.pojo.Match;

public interface DaoInterface {
	
	ArrayList<Match> getAllMatches(Connection connection) throws Exception;
	
	ArrayList<Match> getMatches(String team,Connection connection) throws Exception;
	
	void addToDatabase(String firstTeam, String secondTeam, String matchDate, int goalFirst, int goalSecond, Connection conn);
	
	boolean delete(int matchId, Connection conn);

}
