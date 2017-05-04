package com.demo.model;

/**
 * @author DELL
 *
 */
public class User {

	private int id;
	private String username;
	private int age;
	private String gender;
	private String birthday;
	
	public User(int id, String username, int age, String gender, String birthday) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
}
