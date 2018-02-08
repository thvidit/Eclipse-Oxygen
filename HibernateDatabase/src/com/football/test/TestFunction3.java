package com.football.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.football.dao.MatchDaoImplemented;
import com.football.java.Match;
import com.football.util.MatchUtil;


public class TestFunction3 {
	
	MatchDaoImplemented md = new MatchDaoImplemented();
	MatchUtil mu = new MatchUtil();
	
	@Test
	public void funcCheck(){
		String team ="Chennaiyan";
		int match_id = 44;
		boolean flag = md.delete(match_id, mu.getSessionFactory());
		List<Match> match = func(match_id);
		assertEquals(0,match.size());
		}
	
	List<Match> func(int match_id) {
		Session session = mu.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			List<Match> match = session.createQuery("from Match where match_id = '" + match_id + "'").list();
			return match;
	}catch(HibernateException e) {
		transaction.rollback();
		e.printStackTrace();
		return null;
	} finally {
		session.close();
	}
}
}