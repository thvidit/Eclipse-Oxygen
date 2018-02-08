package com.football.dao;

import java.util.List;

import com.football.bean.Match;

public interface MatchDao {
	
	public List<Match> getAllMatches();
	
	public List<Match> getMatches(String team);
	
	public String addMatch(String firstTeam, String secondTeam, String date, int goalsFirst, int goalsSecond);

}
