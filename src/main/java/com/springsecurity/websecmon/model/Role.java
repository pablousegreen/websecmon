package com.springsecurity.websecmon.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
public class Role {

	private String role;

    public Role() {
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
