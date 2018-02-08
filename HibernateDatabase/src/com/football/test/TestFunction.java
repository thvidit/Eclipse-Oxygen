package com.football.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.football.dao.MatchDaoImplemented;
import com.football.java.Match;
import com.football.util.MatchUtil;


public class TestFunction {
	
	MatchDaoImplemented md = new MatchDaoImplemented();
	MatchUtil mu = new MatchUtil();
	
	@Test
	public void funcCheckInsert(){
		String firstTeam = "Goa";
		String secondTeam ="Kerala Blasters";
		int gFirst = 1, gSecond =2;
		Match match = md.addMatch(firstTeam, secondTeam,new Timestamp(System.currentTimeMillis()),gFirst, gSecond,mu.getSessionFactory() );
		Match shouldMatch = new Match();
		shouldMatch.setFirst_team_name(firstTeam);
		shouldMatch.setSecond_team_name(secondTeam);
		shouldMatch.setFirst_team_goals(gFirst);
		shouldMatch.setSecond_team_goals(gSecond);
		assertEquals(shouldMatch.getFirst_team_name(),match.getFirst_team_name());
		assertEquals(shouldMatch.getSecond_team_name(),match.getSecond_team_name());
	}
	
	@Test
	public void funcCheckQuery(){
		String team ="Chennaiyan";
		List<Match> matches = md.getMatches(team, mu.getSessionFactory());
		int i=1;
		for(Match match : matches) {
			if(i<=3) {
				assertEquals(i,match.getMatch_id());
				i++;
			}else {
				break;
			}
		}
		
	}

}
