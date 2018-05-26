package com.springsecurity.websecmon.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Users {

	 @Id
	 @Indexed(direction = IndexDirection.ASCENDING)
    private String id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private int active;
    private List<Role> roles;

    public Users() {
    }

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Users(String email, String password, String name, String lastName, int active, List<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.roles = roles;
	}

    
}
