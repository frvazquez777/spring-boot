package com.frvazquez.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role", schema = "rehomex", uniqueConstraints = @UniqueConstraint(columnNames = { "role",
		"username" }))
public class UserRoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7585633949187333013L;
	private Integer id;
	private UserEntity user;
	private String role;

	public UserRoleEntity() {

	}

	public UserRoleEntity(Integer id, UserEntity user, String role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	// GETTERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	public UserEntity getUser() {
		return user;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return role;
	}

	// SETTERS
	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", role=" + role + "]";
	}

}
