package com.swamy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles_table")
public class Roles implements GrantedAuthority{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role;
	
	public Roles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public Roles(String role) {
		super();
		this.role = role;
	}

	public Roles() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", role=" + role + "]";
	}

	@Override
	public String getAuthority() {
		
		return this.role;
	}
	

}
