package com.football.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

import com.football.model.Driver;
import com.football.pojo.Match;
import com.google.gson.Gson;

public class testFunction {
	
	@Test
	public void checkFunction() throws Exception {
		ArrayList<Match> matches = null;
		Driver driver = new Driver();
		matches = driver.getAllMatches();
		Gson gson = new Gson();
		System.out.println(gson.toJson(matches));
		String getData = gson.toJson(matches);	
		
		BufferedReader br = new BufferedReader(new FileReader("D:/getallmatches.json"));
		String line=null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		assertEquals(sb.toString(), getData);
	}
	
	@Test
	public void checkGetMatches() throws Exception{
		ArrayList<Match> matches = null;
		Driver driver = new Driver();
		matches = driver.getMatches("Goa");
		Gson gson = new Gson();
		System.out.println(gson.toJson(matches));
		String getData = gson.toJson(matches);	
		
		BufferedReader br = new BufferedReader(new FileReader("D:/goa.json"));
		String line=null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		assertEquals(sb.toString(), getData);
	}

}
