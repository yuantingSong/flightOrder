package com.web.airplane.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId", unique = true, nullable = false)
	private long userId;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "Admin")
	private boolean Admin;
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL)
	private List<Person> persons;


	protected User() {
		this.Admin = false;
		this.persons = new ArrayList<Person>();
	}

	public User(String name, String password) {
		this.username = name;
		this.password = password;
		this.Admin = false;
		this.persons = new ArrayList<Person>();
	}
	
	public User(String name, String password, boolean admin) {
		this.username = name;
		this.password = password;
		this.Admin = true;
		this.persons = new ArrayList<Person>();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = userId;
	}
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean Admin) {
		this.Admin = Admin;
	}
	
}
