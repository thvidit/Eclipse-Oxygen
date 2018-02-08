package com.orhcard.driver;

import com.orchard.pojo.CampusMinds;
import com.orchard.pojo.Lead;
import com.orchard.pojo.OrchardHeads;
import com.orhcard.dao.orchardDaoImplemented;

public class OrchardDriver {
	
	public static void main(String[] args) {
		
		orchardDaoImplemented o = new orchardDaoImplemented();
		CampusMinds c = new CampusMinds();
		Lead l = new Lead();
		OrchardHeads head = new OrchardHeads();
		try {
			o.addData();
			o.getData();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
