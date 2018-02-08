package com.football.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class MatchUtil {
	
	 private static final SessionFactory sessionFactory;
	    static {
	        try {
	            sessionFactory = new Configuration().configure()
	                    .buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("SessionFactory creation failed" + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
