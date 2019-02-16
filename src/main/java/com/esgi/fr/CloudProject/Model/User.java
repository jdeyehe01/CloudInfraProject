package com.esgi.fr.CloudProject.Model;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String function;

		

	public User(String firstName, String lastName, String email, String function) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.function = function;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	
	@Override
	public String toString() {
		return "User : firstName : " + firstName + ", lastName :" + lastName + ", email :" + email + ", function :" + function;
	}
}
