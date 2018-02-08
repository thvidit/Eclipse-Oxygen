package com.jira.models;

import javax.persistence.*;

@Entity
@Table(name = "Capabilities")
public class Capabilities {
	
	private int c_id;
	private String c_name;
	
	
	public Capabilities() {
		//Empty Constructor
	}
	
	@Id
	@GeneratedValue
	@Column(name="c_id")
	public int getC_id() {
		return c_id;
	}
	
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	@Column(name="c_name")
	public String getC_name() {
		return c_name;
	}
	
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

}
