/*xml sd and xml schema, sa and soap,wsdl */package Hackerrank;
"%JAVA_HOME%\bin"\keytool -genkeypair -alias fig -keyalg RSA -keypass fig_store_pass -storepass vidit -keystore D:\keystore\fig.keystore


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class question {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size");
		int size = in.nextInt();
		if(size<=100){
		int[] arr = new int[size];
		int prev =-1;
		for (int i = 0; i < size; i++) {
			 int num = (int) (Math.random() * 100);
			arr[i] = num;
		   
		    
		    System.out.print("Array" + arr[i] + " ");
		}
		
		
		
		
		operations op = new operations();  //object of class
					
		int middle =	 op.findMiddle(size);
		int end = size-1;
		op.reverse(arr, middle, end);
	
	
		}else{
			System.out.print("Please enter a value less than 100");
		}
	}
	
}
