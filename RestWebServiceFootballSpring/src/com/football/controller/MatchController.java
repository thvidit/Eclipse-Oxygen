package com.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.football.bean.Match;
import com.football.service.MatchService;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@RequestMapping(value = "/getallmatches", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Match>> allMatches() {

	  HttpHeaders headers = new HttpHeaders();
	  List<Match> matches = matchService.getAllMatches();

	  if (matches == null) {
	   return new ResponseEntity<List<Match>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(matches.size()));
	  
	  return new ResponseEntity<List<Match>>(matches, headers, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/getmatches", method = RequestMethod.POST, produces = "application/json")
	 public ResponseEntity<List<Match>> matches(@RequestBody String team) {

	  HttpHeaders headers = new HttpHeaders();
	  List<Match> matches = matchService.getMatches(team);

	  if (matches == null) {
	   return new ResponseEntity<List<Match>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(matches.size()));
	  return new ResponseEntity<List<Match>>(matches, headers, HttpStatus.OK);
	 }

}
