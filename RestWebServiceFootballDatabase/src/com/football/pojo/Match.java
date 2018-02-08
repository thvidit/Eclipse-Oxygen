package com.football.pojo;

import java.sql.Timestamp;

public class Match {
	private String firstTeamName;
	private String secondTeamName;
	private Timestamp date;
	private int goalsFirst;
	private int goalsSecond;
	
	public Match() {}
	
	public Match(String firstTeamName, String secondTeamName, Timestamp date,int goalsFirst,int goalsSecond) {
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
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
