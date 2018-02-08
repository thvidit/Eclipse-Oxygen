package com.orchard.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orchardHeads")
public class OrchardHeads {
	long MID;
	String name;
	String location;
	int trackID;
	
	public OrchardHeads(){
		
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
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
	
	@OneToOne(cascade = CascadeType.ALL,targetEntity= Lead.class)
    @JoinColumn(name = "trackID")
	public int getTrackID() {
		return trackID;
	}
	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}

}
