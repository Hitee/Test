package com.deloitte.trg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User {
	@NotNull(message="Please enter userid")
	private String userId;	
	@NotNull(message = "Please enter your password.")
    @Size(min = 7, max = 15, message = "Your password must between 7 and 15 characters")
	private String password;	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
}
