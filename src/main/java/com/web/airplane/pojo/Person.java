package com.web.airplane.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="personId", unique = true, nullable = false)
	private long personId;
	
	@Column(name="firstname", unique=false, nullable = false)
	private String firstname;
	
	@Column(name="lastname", unique=false, nullable = false)
	private String lastname;
	
	@Column(name="birthday", unique=false, nullable = true)
	private String birthday;
	
	@Column(name="age", unique=false, nullable = false)
	private int age;
	
	@Column(name="email", unique=false, nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public Person() {
		
	}
	
	public Person(String firstname, String lastname, String birthday, int age, String email, User user) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.age = age;
		this.email = email;
		this.user = user;
	}
	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
