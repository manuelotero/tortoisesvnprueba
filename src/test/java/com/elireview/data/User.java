package com.elireview.data;

public class User {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String userName;
	private String password;
	
	public User(String userName,String password){
		this.userName = userName;
		this.password = password;
		}
	
	public User(String firstName,String lastName,String email,String userName, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
		this.userName = userName;
		this.password = password;
		
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	
	
	

}
