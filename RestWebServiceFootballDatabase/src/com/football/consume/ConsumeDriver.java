package com.football.consume;

public class ConsumeDriver {
	
	public static void main(String[] args) {
		
		ConsumeApis api = new ConsumeApis();
		
		try {
			api.consumeGetAllMatches();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
