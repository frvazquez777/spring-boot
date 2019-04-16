package com.frvazquez.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "contact", schema = "rehomex", uniqueConstraints = {@UniqueConstraint(columnNames = { "telephone" }) })
public class ContactEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstname;
	private String lastname;
	private String telephone;
	private String city;

	public ContactEntity() {

	}

	public ContactEntity(String firstname, String lastname, String telephone, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.city = city;
	}

	public ContactEntity(int id, String firstname, String lastname, String telephone, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.city = city;
	}

	// GETTERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone
				+ ", city=" + city + "]";
	}

}
