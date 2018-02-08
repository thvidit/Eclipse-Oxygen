package com.orchard.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tracks")
public class OrchardTracks {
	
	
	int trackId;
	String trackName;
	
	public OrchardTracks() { /* Empty Constructor */ }
	
	public OrchardTracks(int trackId, String trackName) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
	}

	@Id
	@GeneratedValue
	@Column(name="trackId")
	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
}
