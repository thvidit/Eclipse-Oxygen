package com.orchard.pojo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Leads")
public class Leads {
	
	int leadsId;
	int mId;
	String name;
	
	Set<Campusminds> campusminds;
	OrchardTracks orchardTrack;
	
	public Leads() { /* Empty Constructor */ }
	
	public Leads(int mId, String name, Set<Campusminds> campusminds) {
		super();
		this.mId = mId;
		this.name = name;
		this.campusminds = campusminds;
	}
	
	@Id
	@GeneratedValue
	public int getLeadsId() {
		return leadsId;
	}

	public void setLeadsId(int leadsId) {
		this.leadsId = leadsId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(targetEntity = Campusminds.class, mappedBy="lead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Campusminds> getCampusminds() {
		return campusminds;
	}

	public void setCampusminds(Set<Campusminds> campusminds) {
		this.campusminds = campusminds;
	}

	@OneToOne(targetEntity = OrchardTracks.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "trackId")
	public OrchardTracks getOrchardTrack() {
		return orchardTrack;
	}

	public void setOrchardTrack(OrchardTracks orchardTrack) {
		this.orchardTrack = orchardTrack;
	}
	

}
