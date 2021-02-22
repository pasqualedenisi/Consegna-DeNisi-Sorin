package com.gruppoweb.gsm.model;

public class User {

	Integer id;
	String name;
	String surname;
	String email;
	Integer type;
	String password;
	
	
	
	public User(Integer id, String name, String surname, String email, Integer type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.type = type;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
