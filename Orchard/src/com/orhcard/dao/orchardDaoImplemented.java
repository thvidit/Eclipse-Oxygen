package com.orhcard.dao;

import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.orchard.Util.OrchardUtil;
import com.orchard.pojo.CampusMinds;
import com.orchard.pojo.Lead;
import com.orchard.pojo.OrchardHeads;


public class orchardDaoImplemented implements orchardDao{

	OrchardUtil util = new OrchardUtil();
	@Override
	public void getData() {
		Session s = util.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			//s.createQuery("from CampusMinds c INNER JOIN c.lead l");
			//transaction.commit();
			
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		
	}

	@Override
	public void addData() {
		Session session = util.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			
			Lead l = new Lead();
			OrchardHeads o = new OrchardHeads();
			transaction = session.beginTransaction();
			l.setLocation("Bhubaneswar"); l.setMID(3); l.setName("Smruti"); l.setOrchardHead("Amar"); l.setTrackID(4);
			session.save(l); 
			transaction.commit();
			
			transaction = session.beginTransaction();
			CampusMinds c = new CampusMinds(2,"Smruti","Bhubaneswar","Vidit",l);
			session.save(c);
			transaction.commit();
			//session1.close();
	}catch(HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
		
	}

}
