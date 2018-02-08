package com.orchard.pojo;

import org.hibernate.Session;
import java.util.*;

import com.orchard.Util.OrchardUtil;

public class driver {

	public static void main(String[] args) {
		
        
        Scanner in = new Scanner(System.in);
        System.out.println("1. Add details\n2. Retrieve Details\n3. Exit");
        int option = in.nextInt();
        DaoImplemented dao = new DaoImplemented();
        
        if(option==1) {
        	System.out.println("1. Add lead\n2. Add Campus Mind\n3. Add Track");
        	int add = in.nextInt();
        	switch(add)
        	{
        	
        	case 1: 
        		Leads lead = new Leads();
        		Session session = OrchardUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        		System.out.print("Enter orchard track ID: ");
        		int orchardTrackId = in.nextInt();
        		OrchardTracks ot = dao.trackName(orchardTrackId);
        		if(ot != null) {
	        		System.out.print("Enter lead id: ");
	        		int leadId = in.nextInt();
	        		System.out.print("Enter lead MID: ");
	        		int leadMid = in.nextInt();
	        		System.out.print("Enter lead name: ");
	        		String leadName = in.nextLine();
	        		
	        		lead.setmId(leadMid); lead.setLeadsId(leadId); lead.setName(leadName); lead.setOrchardTrack(ot);
	        		session.save(lead);
	        		session.getTransaction().commit();
	        		session.close();
        		}else {
        			throw new RuntimeException("No such track exists!");
        		}
        		
        		break;
        	
        	case 2:
        		Campusminds cm = new Campusminds();
        		session = OrchardUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        		System.out.print("Enter orchard track ID: ");
        		int trackId = in.nextInt();
        		OrchardTracks o = dao.trackName(trackId);
        		if(o != null) {
	        		System.out.print("Enter lead id: ");
	        		int leadId = in.nextInt();
	        		Leads studentLead = dao.getLead(leadId);
	        		if(studentLead != null) {
		        		System.out.print("Enter lead MID: ");
		        		int mid = in.nextInt();
		        		System.out.print("Enter lead name: ");
		        		String name = in.nextLine();
		        		System.out.print("Enter lead MID: ");
		        		cm.setmId(mid); cm.setName(name); cm.setLead(studentLead);
		        		session.save(cm);
		        		session.getTransaction().commit();
		        		session.close();
        		}else {
        			throw new RuntimeException("No such lead exists!");
        		}
        	}else {
        		throw new RuntimeException("No such track exists!");
        	}
        		break;
        		
        	case 3:
        		OrchardTracks track = new OrchardTracks();
        		session = OrchardUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        		System.out.print("Enter orchard track ID: ");
        		int id = in.nextInt();
        		System.out.print("Enter orchard track Name: ");
        		String name = in.nextLine();
        		track.setTrackId(id); track.setTrackName(name);
        		session.save(track);
        		session.getTransaction().commit();
        		session.close();
        		
        		break;
        	}
        }
        else if(option==2) {
        	System.out.print("Enter lead name: ");
        	in.nextLine();
        	String leadName = in.nextLine();
        	dao.retrieve(leadName);
        	
        }else if(option==3) {
        	System.exit(3);
        }
  
	}
}
