/* ---------------------------------------------------------------------------------------------------------------------
Question statement: 
Create an abstract class company which has different departments named Technology, admin, accounts and maintenance. Create methods to add an employee
to the database and user should be able to search the database using name, phone, address or department of the employee.
--------------------------------------------------------------------------------------------------------------------------- */

package Hackerrank;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



abstract class Company
{
	abstract public String department();
	abstract public int name(String name);
	abstract public int phone(String phone);
	abstract public int address(String add);
	abstract public ArrayList<String> getName();
	abstract public ArrayList<String> getPhone();
	abstract public ArrayList<String> getAddress();
	
	
	public void add(String name, String phone, String add,ArrayList<String> names, ArrayList<String> phones, ArrayList<String> address){
		names.add(name);
		phones.add(phone);
		address.add(add);
		System.out.println("Added Employee Details:\n" +"Department: " + this.department() 
        		+ "\n" + "Name: " + name 
        		+ "\n" +"Phone: " + phone
        		+ "\n" + "Address: "  + add + "\n");
	}
	
	public int search(String name, ArrayList<String> list){
		int n=0;
		while( n < list.size()){
			if(list.get(n).equals(name)){
				return n;
			}else{
				n++;
			}
		}
		return -1;
	}
	
	
	public void printDetails(String name, String phone, String address) 
	{
        System.out.println("Employee Details:\n" +"Department: " + this.department() 
        		+ "\n" + "Name: " + name 
        		+ "\n" +"Phone: " + phone
        		+ "\n" + "Address: "  + address + "\n");
	}
}

class Technology extends Company
{
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> phones = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	
	Technology(){
		names.add("vidit");names.add("gaurav");names.add("shubham");names.add("rajat");
		phones.add("8130587533");phones.add("1111111111");phones.add("7895883994");phones.add("0000000000");
		address.add("delhi");address.add("mumbai");address.add("pune");address.add("kolkata");
	}
	
	
	public String department(){
		return "Technology";
	}
	

	public int name(String name) {
		int result = search(name, names);
		return result;
	}

	public int phone(String phone) {
		int result = search(phone, phones);
		return result;
	}

	
	public int address(String add) {
		int result = search(add, address);
		return result;
	}
	
	public ArrayList<String> getName(){
		return names;
	}
	
	public ArrayList<String> getPhone(){
		return phones;
	}
	
	public ArrayList<String> getAddress(){
		return address;
	}

}

class Admin extends Company
{
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> phones = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	
	Admin(){
		names.add("vidit");names.add("gaurav");names.add("shubham");names.add("rajat");
		phones.add("8130587533");phones.add("1111111111");phones.add("7895883994");phones.add("0000000000");
		address.add("delhi");names.add("mumbai");names.add("pune");names.add("kolkata");
	}
	
	
	public String department(){
		return "Admin";
	}
	

	public int name(String name) {
		int result = search(name, names);
		return result;
	}

	public int phone(String phone) {
		int result = search(phone, phones);
		return result;
	}

	
	public int address(String add) {
		int result = search(add, address);
		return result;
	}
	
	public ArrayList<String> getName(){
		return names;
	}
	
	public ArrayList<String> getPhone(){
		return phones;
	}
	
	public ArrayList<String> getAddress(){
		return address;
	}
}

class Accounts extends Company
{
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> phones = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	
	Accounts(){
		names.add("vidit");names.add("gaurav");names.add("shubham");names.add("rajat");
		phones.add("8130587533");phones.add("1111111111");phones.add("7895883994");phones.add("0000000000");
		address.add("delhi");names.add("mumbai");names.add("pune");names.add("kolkata");
	}
	
	
	public String department(){
		return "Accounts";
	}
	

	public int name(String name) {
		int result = search(name, names);
		return result;
	}

	public int phone(String phone) {
		int result = search(phone, phones);
		return result;
	}

	
	public int address(String add) {
		int result = search(add, address);
		return result;
	}
	
	public ArrayList<String> getName(){
		return names;
	}
	
	public ArrayList<String> getPhone(){
		return phones;
	}
	
	public ArrayList<String> getAddress(){
		return address;
	}
}

class Maintenance extends Company
{
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<String> phones = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	
	Maintenance(){
		names.add("vidit");names.add("gaurav");names.add("shubham");names.add("rajat");
		phones.add("8130587533");phones.add("1111111111");phones.add("7895883994");phones.add("0000000000");
		address.add("delhi");names.add("mumbai");names.add("pune");names.add("kolkata");
	}
	
	
	public String department(){
		return "Maintenance";
	}

	public int name(String name) {
		int result = search(name, names);
		return result;
	}

	public int phone(String phone) {
		int result = search(phone, phones);
		return result;
	}

	
	public int address(String add) {
		int result = search(add, address);
		return result;
	}
	
	public ArrayList<String> getName(){
		return names;
	}
	
	public ArrayList<String> getPhone(){
		return phones;
	}
	
	public ArrayList<String> getAddress(){
		return address;
	}
	
	
}

public class Employee{
	
	public static void main(String[] args)
	{
		int i,j,n;
		
		Company technology = new Technology();
		Company admin = new Admin();
		Company accounts = new Accounts();
		Company maintenance = new Maintenance();
		String input1 = null;
		String input2 = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select operation:\n1. Search\n2. Add to database: ");
		String input0 = sc.nextLine();
		if(input0.equals("1")){
			input0  = "search";
			System.out.println("Search records by: ");
			input1 = sc.nextLine();
			System.out.println("Enter the value: ");
			input2 = sc.nextLine();
		}else if(input0.equals("2")){
			System.out.println("Enter department of the employee: ");
			String department = sc.nextLine();
			System.out.println("Enter the name: ");
			String name = sc.nextLine();
			System.out.println("Enter the phone: ");
			String phone = sc.nextLine();
			System.out.println("Enter the address: ");
			String address = sc.nextLine();
			if(department.toLowerCase().equals("technology")){
				technology.add(name,phone,address,technology.getName(),technology.getPhone(),technology.getAddress());
			}
			else if(department.toLowerCase().equals("admin")){
				admin.add(name,phone,address,admin.getName(),admin.getPhone(),admin.getAddress());			
				}
			if(department.toLowerCase().equals("accounts")){
				accounts.add(name,phone,address,accounts.getName(),accounts.getPhone(),accounts.getAddress());			
				}
			if(department.toLowerCase().equals("maintenance")){
				maintenance.add(name,phone,address,maintenance.getName(),maintenance.getPhone(),maintenance.getAddress());		
				}
		}
		
		System.out.println("Select operation:\n1. Search\n2. Add to database: ");
		String input = sc.nextLine();
		if(input.equals("1")){
			input0  = "search";
			System.out.println("Search records by: ");
			input1 = sc.nextLine();
			System.out.println("Enter the value: ");
			input2 = sc.nextLine();
		}
		
		
		
		
		if(input2 != null && input1 !=null){
		
		if(input1.toLowerCase().equals("name") && input2 != null && input1 !=null){
			
			int index1 = technology.name(input2);
			//System.out.print("okay" + index1);
			if(technology.name(input2) !=-1){
				String name = technology.getName().get(index1);
				String phone = technology.getPhone().get(index1);
				String address = technology.getAddress().get(index1);
				technology.printDetails(name, phone, address);
				
			}
			int index2 = admin.name(input2);
			if(admin.name(input2) !=-1){
				String name = admin.getName().get(index2);
				String phone = admin.getPhone().get(index2);
				String address = admin.getAddress().get(index2);
				admin.printDetails(name, phone, address);
				
			}
			
			int index3 = accounts.name(input2);
			if(accounts.name(input2) !=-1){
				String name = accounts.getName().get(index3);
				String phone = accounts.getPhone().get(index3);
				String address = accounts.getAddress().get(index3);
				accounts.printDetails(name, phone, address);
				
			}
			
			int index4 = maintenance.name(input2);
			if(maintenance.name(input2) !=-1){
				String name = accounts.getName().get(index4);
				String phone = accounts.getPhone().get(index4);
				String address = accounts.getAddress().get(index4);
				maintenance.printDetails(name, phone, address);
				
			}
			
			
		}
		
		else if(input1.toLowerCase().equals("phone") && input2 != null && input1 !=null){
			int index1 = technology.phone(input2);
			if(index1 !=-1){
				String name = technology.getName().get(index1);
				String phone = technology.getPhone().get(index1);
				String address = technology.getAddress().get(index1);
				technology.printDetails(name, phone, address);
				
			}
			int index2 = admin.phone(input2);
			if(index2 !=-1){
				String name = admin.getName().get(index2);
				String phone = admin.getPhone().get(index2);
				String address = admin.getAddress().get(index2);
				admin.printDetails(name, phone, address);
				
			}
			
			int index3 = accounts.phone(input2);
			if(index3 !=-1){
				String name = accounts.getName().get(index3);
				String phone = accounts.getPhone().get(index3);
				String address = accounts.getAddress().get(index3);
				accounts.printDetails(name, phone, address);
				
			}
			
			int index4 = maintenance.phone(input2);
			if(maintenance.name(input2) !=-1){
				String name = accounts.getName().get(index4);
				String phone = accounts.getPhone().get(index4);
				String address = accounts.getAddress().get(index4);
				maintenance.printDetails(name, phone, address);
				
			}
			
			
		}
		
		else if(input1.toLowerCase().equals("address") && input2 != null && input1 !=null){
			int index1 = technology.address(input2);
			if(index1 !=-1){
				String name = technology.getName().get(index1);
				String phone = technology.getPhone().get(index1);
				String address = technology.getAddress().get(index1);
				technology.printDetails(name, phone, address);
				
			}
			int index2 = admin.address(input2);
			if(index2 !=-1){
				String name = admin.getName().get(index2);
				String phone = admin.getPhone().get(index2);
				String address = admin.getAddress().get(index2);
				admin.printDetails(name, phone, address);
				
			}
			
			int index3 = accounts.address(input2);
			if(index3 !=-1){
				String name = accounts.getName().get(index3);
				String phone = accounts.getPhone().get(index3);
				String address = accounts.getAddress().get(index3);
				accounts.printDetails(name, phone, address);
				
			}
			
			int index4 = maintenance.address(input2);
			if(index4 !=-1){
				String name = accounts.getName().get(index4);
				String phone = accounts.getPhone().get(index4);
				String address = accounts.getAddress().get(index4);
				maintenance.printDetails(name, phone, address);
				
			}		
			
			
			
			
		}
		
		else if(input1.toLowerCase().equals("department") && input2 != null && input1 !=null){
			if(input2.toLowerCase().equals("technology")){
				ArrayList<String> name = technology.getName();
				ArrayList<String> phone = technology.getPhone();
				ArrayList<String> address = technology.getAddress();
				for(int m=0;m<name.size();m++){
					System.out.println("Employee Details:\n" +"Department: " + "Technology" 
        		+ "\n" + "Name: " + name.get(m) 
        		+ "\n" +"Phone: " + phone.get(m)
        		+ "\n" + "Address: "  + address.get(m) + "\n");
				}
				
			}
			if(input2.toLowerCase().equals("admin")){
				ArrayList<String> name = admin.getName();
				ArrayList<String> phone = admin.getPhone();
				ArrayList<String> address = admin.getAddress();
				for(int m=0;m<name.size();m++){
					System.out.println("Employee Details:\n" +"Department: " + "Admin" 
        		+ "\n" + "Name: " + name.get(m) 
        		+ "\n" +"Phone: " + phone.get(m)
        		+ "\n" + "Address: "  + address.get(m) + "\n");
				}
				
			}
			if(input2.toLowerCase().equals("accounts")){
				ArrayList<String> name = accounts.getName();
				ArrayList<String> phone = accounts.getPhone();
				ArrayList<String> address = accounts.getAddress();
				for(int m=0;m<name.size();m++){
					System.out.println("Employee Details:\n" +"Department: " + "Accounts" 
        		+ "\n" + "Name: " + name.get(m) 
        		+ "\n" +"Phone: " + phone.get(m)
        		+ "\n" + "Address: "  + address.get(m) + "\n");
				}
				
			}
			if(input2.toLowerCase().equals("maintenance")){
				ArrayList<String> name = maintenance.getName();
				ArrayList<String> phone = maintenance.getPhone();
				ArrayList<String> address = maintenance.getAddress();
				for(int m=0;m<name.size();m++){
					System.out.println("Employee Details:\n" +"Department: " + "Maintenance" 
        		+ "\n" + "Name: " + name.get(m) 
        		+ "\n" +"Phone: " + phone.get(m)
        		+ "\n" + "Address: "  + address.get(m) + "\n");
				}
				
			}
			
	}	
		}
}
}