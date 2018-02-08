package com.orchard.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="lead")
public class Lead {
	
	long MID;
	String name;
	String location;
	@Id
	@GeneratedValue
	@Column(name = "trackID")
	long trackID;
	String orchardHead;
	
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
	
	
	public long getTrackID() {
		return trackID;
	}
	public void setTrackID(long trackID) {
		this.trackID = trackID;
	}
	public String getOrchardHead() {
		return orchardHead;
	}
	public void setOrchardHead(String orchardHead) {
		this.orchardHead = orchardHead;
	}
	
}
