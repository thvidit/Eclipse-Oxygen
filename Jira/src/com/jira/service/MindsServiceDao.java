package com.jira.service;

import java.util.Set;

import com.jira.models.Capabilities;

public interface MindsServiceDao {
	
	Set<Capabilities> getCapabilites(String m_id);

}
