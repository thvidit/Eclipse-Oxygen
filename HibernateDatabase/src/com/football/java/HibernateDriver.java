package com.football.java;

import java.sql.Timestamp;

import org.hibernate.SessionFactory;
import com.football.dao.MatchDaoImplemented;
import com.football.util.MatchUtil;

public class HibernateDriver {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int a=0,b=0;
		final SessionFactory sessionFactory;
		MatchDaoImplemented md = new MatchDaoImplemented();
		MatchUtil util = new MatchUtil();
		
		try {
			sessionFactory = util.getSessionFactory();
			md.getMatches("Goa",sessionFactory);
			md.addMatch("Goa","Chennaiyan",new Timestamp(System.currentTimeMillis()), a+1,b+2,sessionFactory);
			md.delete(22,sessionFactory);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
