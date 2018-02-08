package com.football.dao;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.football.bean.Match;

@Repository("matchDao")
public class MatchDaoImplementation implements MatchDao{

	private JdbcTemplate jdbcTemplate;

	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	 
	@Override
	public List<Match> getAllMatches() {
		List<Match> matches = null;
		try {
			   matches = jdbcTemplate.query("SELECT * FROM matches",new BeanPropertyRowMapper<Match>(Match.class));   
			  } catch (DataAccessException e) {
			   e.printStackTrace();
			  }
		return matches;
	}

	@Override
	public List<Match> getMatches(String team) {
		List<Match> matches = null;
		try {
			   matches = jdbcTemplate.query("SELECT * FROM matches WHERE first_team_name=" + team,new BeanPropertyRowMapper<Match>(Match.class));   
			  } catch (DataAccessException e) {
			   e.printStackTrace();
			  }
		return matches;
	}

	@Override
	public String addMatch(String firstTeam, String secondTeam, String date, int goalsFirst, int goalsSecond) {
		try {
			jdbcTemplate.update(
				    "insert into matches(MATCH_DATE,FIRST_TEAM_NAME,SECOND_TEAM_NAME,FIRST_TEAM_GOALS,SECOND_TEAM_GOALS)VALUES(?,?,?,?)", new Object[] {
				      date, firstTeam, secondTeam, goalsFirst, goalsSecond});
				  return "Details Added Successfully";
		}catch(Exception e) {
			return "Some exception Occured";
		}
		
	}

}
