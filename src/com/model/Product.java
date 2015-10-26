package com.model;
import java.util.*;

public class Product implements java.io.Serializable {
	
	//user ID
	private Integer id;
	//Which family belong to
	private String family;
	//product name
	private String production;	
	private Set<TestCase> testcases=new HashSet<TestCase>();
	private Set<TestResult> results=new HashSet<TestResult>();
	
	public Product() {
	}
	
	public Product(String family, String production,Set<TestCase> testcases) {
		this.family = family;
		this.production = production;
		this.testcases = testcases;
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
	
	public Set<TestCase> gettestcases() {
		return this.testcases;
	}

	public void settestcases(Set<TestCase> testcases) {
		this.testcases = testcases;
	}
	
	public Set<TestResult> getResults() {
		return this.results;
	}

	public void setResults(Set<TestResult> results) {
		this.results = results;
	}

	
}