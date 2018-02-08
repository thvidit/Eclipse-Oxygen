package com.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.bean.Match;
import com.football.dao.MatchDao;

@Service("matchService")
public class MatchServiceImplementation implements MatchService{

	@Autowired
	private MatchDao matchDao;
	
	@Override
	public List<Match> getAllMatches() {
		List<Match> matches = matchDao.getAllMatches();
		return matches;
	}

	@Override
	public List<Match> getMatches(String team) {
		List<Match> matches = matchDao.getMatches(team);
		return matches;
	}

	@Override
	public String addMatch(String firstTeam, String secondTeam, String date, int goalsFirst, int goalsSecond) {
		String result = matchDao.addMatch(firstTeam, secondTeam, date, goalsFirst, goalsSecond);
		return result;
	}
	
	

}
