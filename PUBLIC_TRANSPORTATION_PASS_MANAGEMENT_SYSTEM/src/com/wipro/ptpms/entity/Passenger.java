package com.wipro.ptpms.entity;

public class Passenger {

	private String passengerId;
	private String name ;
	private String email;
	
	    public Passenger(String passengerId, String name, String email) {
	        this.passengerId = passengerId;
	        this.name = name;
	        this.email = email;
	    }
	
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
