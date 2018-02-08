package com.jira.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name ="campusMinds")
public class Minds {
	
	private int m_id;
	private String m_name;
	private String m_email;
	private String m_Ctotal;
	private Set<Capabilities> capabilities;
	
	public Minds() {	
		
		//Empty Constructor
			
	}

	@Id
	@GeneratedValue
	@Column(name = "m_id")
	public int getM_id() {
		return m_id;
	}


	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	@Column(name="m_name")
	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	@Column(name="m_email")
	public String getM_email() {
		return m_email;
	}


	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	@Column(name="m_cTotal")
	public String getM_Ctotal() {
		return m_Ctotal;
	}


	public void setM_Ctotal(String m_Ctotal) {
		this.m_Ctotal = m_Ctotal;
	}

	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name ="mindsCapabilities", joinColumns= {@JoinColumn(name= "m_id")}, inverseJoinColumns = {@JoinColumn(name="c_id")})
	public Set<Capabilities> getCapabilities() {
		return capabilities;
	}


	public void setCapabilities(Set<Capabilities> capabilities) {
		this.capabilities = capabilities;
	}

	
	
	
	

}
