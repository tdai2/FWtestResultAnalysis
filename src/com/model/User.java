package com.model;
public class User implements java.io.Serializable {
	private Integer id;
	private String name;
	private String pwd;
	
	public User() {
	}
	
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}