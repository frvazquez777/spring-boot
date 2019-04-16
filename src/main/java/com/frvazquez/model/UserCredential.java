package com.frvazquez.model;

import java.io.Serializable;

public class UserCredential implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public UserCredential() {

	}

	public UserCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//GETTERS
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	//SETTERS
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Validacion campos
	
	public Boolean validUsername(String user) {
		boolean valid = false;
		
		if(username.equals(user)) {
			valid = true;
		}
		return valid;
	}

	public Boolean validPassword(String pass) {
		boolean valid = false;
		if(password.equals(pass)) {
			valid = true;
		}
		return valid;
	}

	@Override
	public String toString() {
		return "UserCredential [username=" + username + ", password=" + password + "]";
	}
}
