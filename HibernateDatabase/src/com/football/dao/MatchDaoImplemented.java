package com.football.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.football.java.Match;

public class MatchDaoImplemented implements MatchDao{
	
	public Match addMatch(String firstTeam, String secondTeam, Timestamp date, int goalsFirst, int goalsSecond, SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Match match = new Match();
			//match.setMatch_id(match_id);
			match.setFirst_team_name(firstTeam);
			match.setSecond_team_name(secondTeam);
			match.setMatch_date(date);
			match.setFirst_team_goals(goalsFirst);
			match.setSecond_team_goals(goalsSecond);
			session.save(match);
			System.out.println("--------------------------------------------------");
			System.out.println("Details added!\nFirst Team: " + firstTeam +"\nSecond Team: " + secondTeam +"\nDate: " + date +"\nGoals: " + goalsFirst + "-" + goalsSecond);
			System.out.println("--------------------------------------------------");
			transaction.commit();
			return match;
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<Match> getMatches(String team, SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			List<Match> matches = session.createQuery("from Match where first_team_name = '" + team + "'").list();
			System.out.print("----------------------------------------------------------\n----- Match Date ------- Opponent -------- Goals ------\n"
					+ "----------------------------------------------------------\n");
			for(Match match : matches) {
				
				System.out.println(match.getMatch_date() + "   " + String.format("%0$-15s", match.getSecond_team_name()) + "   " + match.getFirst_team_goals() + "-" + match.getSecond_team_goals());
			}
			System.out.println("--------------------------------------------------");
			return matches;
		}catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}
	
	public boolean delete(int match_id, SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Match match = new Match();
			match.setMatch_id(match_id);
			session.delete(match);
			transaction.commit();
			System.out.println("Deleted record where Match ID: " + match_id +"!");	
				
			System.out.println("--------------------------------------------------");
			
			return true;
		}catch(HibernateException e) {
			transaction.rollback();
			System.out.println("Record not present!");	
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
