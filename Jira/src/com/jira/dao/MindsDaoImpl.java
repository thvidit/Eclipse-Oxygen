package com.jira.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jira.models.Capabilities;
import com.jira.models.Minds;
import com.jira.util.HibernateUtil;

public class MindsDaoImpl implements MindsDaoInterface{

	HibernateUtil util = new HibernateUtil();
	
	@Override
	public Set<Capabilities> getCapabilities(String m_id) {
		Session session = util.getSessionFactory().openSession();
		Transaction transaction;
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Minds> minds = (List<Minds>) session.createQuery("From Minds Where m_id='" + m_id + "'").list();
			Set<Capabilities> capabilities = minds.get(0).getCapabilities();
			
			return capabilities;
		}catch(HibernateException e) {
			e.printStackTrace();
			session.close();
			return null;
		}
	}

}
