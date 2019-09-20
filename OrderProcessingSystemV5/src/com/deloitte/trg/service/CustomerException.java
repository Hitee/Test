package com.deloitte.trg.service;

import org.springframework.stereotype.Component;

@Component
public class CustomerException extends Exception {
	private String message;
	
	public CustomerException() {
		
	}

	public CustomerException(String message) {
		super();
		this.message = message;
	}
	

	@Override
	public String getMessage() {
		return this.message+"\n"+super.getMessage();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
