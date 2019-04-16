package com.frvazquez.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContactModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String telephone;
	private String city;
	private Boolean su;
	
	public ContactModel() {

	}

	public ContactModel(String firstname, String lastname, String telephone, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.city = city;
	}

	// GETTERS
	@NotNull
	@Size(min=3, max=45)
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	@NotNull
	@Size(min=8, max=12)
	public String getTelephone() {
		return telephone;
	}

	public String getCity() {
		return city;
	}

	public Boolean getSu() {
		return su;
	}

	// SETTERS
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void setSu(Boolean su) {
		this.su = su;
	}

	@Override
	public String toString() {
		return "ContactModel [firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone
				+ ", city=" + city + ", su=" + su + "]";
	}

}
