package com.main;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.codehaus.jackson.annotate.JsonProperty;

@PersistenceCapable
public class POJO {
	@Persistent
	@JsonProperty("name")
	private String name;

	@Persistent
	@JsonProperty("password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
