package com.football.consume;

public class ConsumeDriver {
	
	public static void main(String[] args) {
		
		ConsumeApis api = new ConsumeApis();
		
		try {
			api.consumeGetAllMatches();
			api.consumeGetMatches();
			api.consumeAddToDatabase();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
