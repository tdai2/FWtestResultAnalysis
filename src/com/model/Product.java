package com.model;
public class Product implements java.io.Serializable {
	
	//user ID
	private Integer id;
	//Which family belong to
	private String family;
	//product name
	private String production;	
	
	public Product() {
	}
	
	public Product(String family, String production) {
		this.family = family;
		this.production = production;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getProduction() {
		return this.production;
	}

	public void setProduction(String production) {
		this.production = production;
	}
	
}