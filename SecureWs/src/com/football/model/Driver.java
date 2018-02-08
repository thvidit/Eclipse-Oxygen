package com.football.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.football.pojo.Match;
import com.football.dao.DaoImplemented;
import com.football.dao.Database;

public class Driver {
	
 Database database= new Database();
	

 public ArrayList<Match> getAllMatches() throws Exception {
			ArrayList<Match> matches = null;
			try {
				Connection connection = database.getConnection();
				DaoImplemented dao = new DaoImplemented();
				matches = dao.getAllMatches(connection);
			}
			catch (Exception e) {
				throw e;
		}
				return matches;
	}
 

 public ArrayList<Match> getMatches(String team) throws Exception {
	ArrayList<Match> matches = null;
	try {
			Connection connection = database.getConnection();
			DaoImplemented dao = new DaoImplemented();
			matches = dao.getMatches(team,connection);
	}
	catch (Exception e) {
		throw e;
     }
		return matches;
 }
 
 
 public void addToDatabase(String firstTeam, String secondTeam, String matchDate, int goalFirst, int goalSecond) {
	 try {
			Connection connection = database.getConnection();
			DaoImplemented dao = new DaoImplemented();
			dao.addToDatabase(firstTeam, secondTeam, matchDate, goalFirst, goalSecond, connection);
	}
	catch (Exception e) {
		e.printStackTrace();
  }
	 
 }
 
 public boolean delete(int matchId) {
	 try {
			Connection connection = database.getConnection();
			DaoImplemented dao = new DaoImplemented();
			return dao.delete(matchId, connection);
	}
	catch (Exception e) {
		e.printStackTrace();
		return false;
}
 }

}