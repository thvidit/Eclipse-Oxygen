package com.football.consume;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.apache.http.message.BasicNameValuePair;

public class ConsumeApis implements ConsumeApisInterface{

	@Override
	public void consumeGetAllMatches() {
		 	final String uri = "http://localhost:6565/RestWebServiceFootballDatabase/rest/WebService/getallmatches";
	     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		     
		    System.out.println("All Matches: " + result + "\n");
		
	}

	@Override
	public void consumeGetMatches() {
		 final String uri = "http://localhost:6565/RestWebServiceFootballDatabase/rest/WebService/getmatches/goa";
		 
		  RestTemplate restTemplate = new RestTemplate();
		  String result = restTemplate.getForObject(uri, String.class);
		     
		  System.out.println("Matches: " + result);		
	}

	@Override
	public void consumeAddToDatabase() {
		 	final String uri = "http://localhost:6565/RestWebServiceFootballDatabase/rest/WebService/addmatch";
		 	
		 	HttpHeaders headers = new HttpHeaders();
		 	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		 	
		 	MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		    params.add("first", "goa");
		    params.add("second", "chennaiyan");
		    params.add("matchDate", "2017-12-13 10:55:32");
		    params.add("gfirst","5");
		    params.add("gsecond","9");
		    //http://localhost:6767/RestWebServiceFootballDatabase/rest/WebService/addmatch?first=goa&second=chennaiyan&matchDate=2013-02-15 12:30:00&gfirst=3&gsecond=1
		    RestTemplate restTemplate = new RestTemplate();
		    
		    System.out.println("Value " + params.get("first"));
		   
		    
		    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		    
		     
		    System.out.println(result);
		
		
	}

	@Override
	public void consumeDelete() {
		// TODO Auto-generated method stub
		
	}
	
	

}
