package com.demo.model;

import java.util.Date;


public class User {
	
	private Integer id;
	
	private String name;

    private Short age;

    private String sex;

    private Date birthday;
    
    public User(Integer id, String name, Short age, String sex, Date birthday) {
		// TODO Auto-generated constructor stub
    	this.id = id;
    	this.name = name;
    	this.age = age;
    	this.sex = sex;
    	this.birthday = birthday;
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

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    

}
