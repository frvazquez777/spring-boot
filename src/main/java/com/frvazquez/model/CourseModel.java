package com.frvazquez.model;

import java.io.Serializable;

public class CourseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private int price;
	private int hours;
	private boolean su;

	public CourseModel() {
	}

	public CourseModel(String name, String description, int price, int hours) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getHours() {
		return hours;
	}

	public boolean isSu() {
		return su;
	}

	// SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setSu(boolean su) {
		this.su = su;
	}

	@Override
	public String toString() {
		return "CourseModel [name=" + name + ", description=" + description + ", price=" + price + ", hours=" + hours
				+ ", su=" + su + "]";
	}

}
