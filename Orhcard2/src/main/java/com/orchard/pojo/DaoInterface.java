package com.orchard.pojo;

import java.util.List;
import java.util.Set;

public interface DaoInterface {
	
	public void insert(OrchardTracks ot, Leads lead, List<Campusminds> cm);
	
	public Set<Campusminds> retrieve(int leadsId);
	
	public Set<Campusminds> retrieve(String leadName);
	
	public OrchardTracks trackName(int id);
	
	public Leads getLead(int leadId);
}
