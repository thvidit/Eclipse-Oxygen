package com.football.consume;

import org.springframework.web.client.RestTemplate;

public class ConsumeApis implements ConsumeApisInterface{

	@Override
	public void consumeGetAllMatches() {
		 final String uri = "http://localhost:6565/RestWebServiceFootballDatabase/rest/WebService/getallmatches";
	     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		     
		    System.out.println(result);
		
	}

	@Override
	public void consumeGetMatches() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consumeAddToDatabase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consumeDelete() {
		// TODO Auto-generated method stub
		
	}
	
	

}
