package com.football.java;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="matches")
public class Match {
	
	private int match_id;
	private Timestamp match_date;
	private String first_team_name;
	private String second_team_name;
	private int first_team_goals;
	private int second_team_goals;
	
	
	public Match() {
		
	}

	@Id
	@Column(name="match_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public Timestamp getMatch_date() {
		return match_date;
	}

	public void setMatch_date(Timestamp match_date) {
		this.match_date = match_date;
	}

	public String getFirst_team_name() {
		return first_team_name;
	}

	public void setFirst_team_name(String first_team_name) {
		this.first_team_name = first_team_name;
	}

	public String getSecond_team_name() {
		return second_team_name;
	}

	public void setSecond_team_name(String second_team_name) {
		this.second_team_name = second_team_name;
	}

	public int getFirst_team_goals() {
		return first_team_goals;
	}

	public void setFirst_team_goals(int first_team_goals) {
		this.first_team_goals = first_team_goals;
	}

	public int getSecond_team_goals() {
		return second_team_goals;
	}

	public void setSecond_team_goals(int second_team_goals) {
		this.second_team_goals = second_team_goals;
	}
	
	
	
}
