package com.football.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {
	private String firstTeamName;
	private String secondTeamName;
	private String date;
	private int goalsFirst;
	private int goalsSecond;
	
	public Match() {}
	
	@JsonCreator
	public Match(@JsonProperty("firstTeam")String firstTeamName, @JsonProperty("secondTeam")String secondTeamName, @JsonProperty("date")String date,@JsonProperty("goalsFirst") int goalsFirst,@JsonProperty("goalsSecond") int goalsSecond) {
		super();
		this.firstTeamName = firstTeamName;
		this.secondTeamName = secondTeamName;
		this.date = date;
		this.goalsFirst = goalsFirst;
		this.goalsSecond = goalsSecond;
	}

	public String getFirstTeamName() {
		return firstTeamName;
	}

	public void setFirstTeamName(String firstTeamName) {
		this.firstTeamName = firstTeamName;
	}

	public String getSecondTeamName() {
		return secondTeamName;
	}

	public void setSecondTeamName(String secondTeamName) {
		this.secondTeamName = secondTeamName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getGoalsFirst() {
		return goalsFirst;
	}

	public void setGoalsFirst(int goalsFirst) {
		this.goalsFirst = goalsFirst;
	}

	public int getGoalsSecond() {
		return goalsSecond;
	}

	public void setGoalsSecond(int goalsSecond) {
		this.goalsSecond = goalsSecond;
	}
	
	@Override
	 public String toString() {
	  StringBuilder str = new StringBuilder();
	  str.append("First Team: " + getFirstTeamName());
	  str.append("Second Team: " + getSecondTeamName());
	  str.append("Date" + getDate());
	  str.append("Goals" + getGoalsFirst() + "-" + getGoalsSecond());
	  return str.toString();
	 }
	
}
