package com.orchard.pojo;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.orchard.Util.OrchardUtil;

public class DaoImplemented implements DaoInterface{
	
	public void insert(OrchardTracks ot, Leads lead, List<Campusminds> cm) {
		 Session session = OrchardUtil.getSessionFactory().openSession();

	        session.beginTransaction();
	        session.save(ot);
	        session.save(lead);
	        for(Campusminds mind : cm )
	        	session.save(mind);
	       
	        session.getTransaction().commit();
		
	}
	
	public Set<Campusminds> retrieve(int leadsId) {
		Session session = OrchardUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			List<Leads> lead = session.createQuery("from Leads where leadsId = '" + leadsId + "'").list();
			Set<Campusminds> cm = lead.get(0).getCampusminds();
			System.out.println("------------------------------------------------------------------------------------\n----- Track Id -----" + "----- Lead ----- " + "----- Campus Mind ----- " + 
			"----- Track name -----\n------------------------------------------------------------------------------------");
			for(Campusminds mind: cm) {
				System.out.println("          " + lead.get(0).getOrchardTrack().getTrackId() + "            " + lead.get(0).getName() + "                 " + mind.getName() + "        "
						+ "      " + lead.get(0).getOrchardTrack().getTrackName());
			}
			return cm;
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}

	public Set<Campusminds> retrieve(String leadName) {
		Session session = OrchardUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			List<Leads> lead = session.createQuery("from Leads where name = '" + leadName+ "'").list();
			Set<Campusminds> cm = lead.get(0).getCampusminds();
			System.out.println("------------------------------------------------------------------------------------\n----- Track Id -----" + "----- Lead ----- " + "----- Campus Mind ----- " + 
			"----- Track name -----\n------------------------------------------------------------------------------------");
			for(Campusminds mind: cm) {
				System.out.println("          " + lead.get(0).getOrchardTrack().getTrackId() + "            " + lead.get(0).getName() + "                 " + mind.getName() + "        "
						+ "      " + lead.get(0).getOrchardTrack().getTrackName());
			}
			return cm;
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public OrchardTracks trackName(int id) {
		Session session = OrchardUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			List<OrchardTracks> ot = session.createQuery("from OrchardTracks where trackId = '" + id + "'").list();
			return ot.get(0);
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public Leads getLead(int leadId) {
		Session session = OrchardUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			List<Leads> lead = session.createQuery("from Leads where leadId = '" + leadId + "'").list();
			return lead.get(0);
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}
		
	}
