package com.model;
public class User implements java.io.Serializable {
	
	//user ID
	private Integer id;
	//user name
	private String name;
	//user password
	private String pwd;
	// user type
	private String type;
	// user email
	private String email;
	// user ssid
	private String ssid;
	// user phone
	private String phone;
		
	
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
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}
	
	public String getSsid() {
		return this.ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String Phone) {
		this.phone = Phone;
	}
}