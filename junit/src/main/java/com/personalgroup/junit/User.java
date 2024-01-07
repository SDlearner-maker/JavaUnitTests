package com.personalgroup.junit;

import java.util.List;

public class User {
	private String password;
    private String role;
    private List<String> posts;    
    private String username;
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getPosts() {
		return posts;
	}
	public void setPosts(List<String> posts) {
		this.posts = posts;
	}
	  
}
