/**
 * 
 */
package com.qa.users;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author raghuveer.mh
 *
 */
public class UsersData {
	
	// pojo = plane old Java Object has created equivalent to partcular JSON
	
	// create the values in the JSON Payload
	String name;
	String job;
	String id;
	String createdAt;
	
	//Default constructor
	public UsersData() {
		
	}
	
	// constructor
	public UsersData(String name, String job) {
		this.name = name;
		this.job = job;
	}

	// create the getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	// need the JACKSON API
	// conversion of JAVA to JSON
	
	
	
}
