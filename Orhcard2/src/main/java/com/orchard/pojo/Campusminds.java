package com.orchard.pojo;

import javax.persistence.*;

@Entity
@Table(name="Campusminds")
public class Campusminds {
	
	long mId;
	String name;
	Leads lead;
	
	public Campusminds() { /* Empty constructor */ }
	
	public Campusminds(long mId, String name) {
		super();
		this.mId = mId;
		this.name = name;
	//	this.trackId = trackId;
	}

	@Id
	@GeneratedValue
	@Column(name="MID")
	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="leadId")
	public Leads getLead() {
		return lead;
	}

	public void setLead(Leads lead) {
		this.lead = lead;
	}
	
	
}
