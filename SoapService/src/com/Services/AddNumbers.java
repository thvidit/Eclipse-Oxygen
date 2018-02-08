package com.Services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class AddNumbers {
	
	@WebMethod
	public int add(int x,int y) {
		
		return x+y;
	}
	
	@WebMethod
	public int subtract(int x,int y) {
		
		return x-y;
	}
	
	@WebMethod
	public int multiply(int x,int y) {
		
		return x*y;
	}
	
	@WebMethod
	public int divide(int x,int y) {
		
		return x/y;
	}
	
	

}
