package com.frvazquez.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "log", schema = "rehomex")
public class LogEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date date;
	private String details;
	private String username;
	private String url;

	public LogEntity() {

	}

	
	public LogEntity(Date date, String details, String username, String url) {
		super();
		this.date = date;
		this.details = details;
		this.username = username;
		this.url = url;
	}


	public LogEntity(int id, Date date, String details, String username, String url) {
		super();
		this.id = id;
		this.date = date;
		this.details = details;
		this.username = username;
		this.url = url;
	}

	// GETTERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	public Date getDate() {
		return date;
	}

	@Column(name="details")
	public String getDetails() {
		return details;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}

	@Column(name="url")
	public String getUrl() {
		return url;
	}

	// SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", date=" + date + ", details=" + details + ", username=" + username + ", url=" + url
				+ "]";
	}

}
