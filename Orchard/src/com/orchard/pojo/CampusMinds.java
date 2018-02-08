package com.orchard.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="campusminds")
public class CampusMinds {
	
	@Id
	@Column(name="MID")
	long MID;
	@Column(name="lead")
	String lead;
	String location;
	String name;
	//long trackID;
	@ManyToOne(cascade = CascadeType.ALL)
	private Lead leader;
	
	public CampusMinds() {}
	
	public CampusMinds(long mID, String lead, String location, String name, Lead leader) {
		super();
		MID = mID;
		this.lead = lead;
		this.location = location;
		this.name = name;
		this.leader = leader;
	}
	public long getMID() {
		return MID;
	}
	public void setMID(long mID) {
		this.MID = mID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}

	public Lead getLeader() {
		return leader;
	}
	public void setLeader(Lead leader) {
		this.leader = leader;
	}
	
}
