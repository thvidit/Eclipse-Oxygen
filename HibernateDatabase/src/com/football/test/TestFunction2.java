package com.football.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.football.dao.MatchDaoImplemented;
import com.football.java.Match;
import com.football.util.MatchUtil;


public class TestFunction2 {
	
	MatchDaoImplemented md = new MatchDaoImplemented();
	MatchUtil mu = new MatchUtil();
	
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
