package com.github.i24x.service.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cuid;
	
	private String name;
	private Integer age;
	private String email;
	private Integer phone;
	public User(){
		this.setCuid("User-"+UUID.randomUUID().toString().replace("-", ""));
	}
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "User [cuid=" + cuid + ", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
