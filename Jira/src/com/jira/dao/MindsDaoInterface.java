package com.jira.dao;

import java.util.Set;
import com.jira.models.*;

public interface MindsDaoInterface {
	
	Set<Capabilities> getCapabilities(String m_id);

}
