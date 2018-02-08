package com.football.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SessionFactory;

import com.football.java.Match;

public interface MatchDao {
	
	Match addMatch(String firstTeam, String secondTeam, Timestamp date, int goalsFirst, int goalsSecond, SessionFactory sessionFactory);

	List<Match> getMatches(String team, SessionFactory sessionFactory);
	
	boolean delete(int match_id, SessionFactory sessionFactory);

}
