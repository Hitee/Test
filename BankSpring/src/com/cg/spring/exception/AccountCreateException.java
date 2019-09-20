package com.cg.spring.exception;
public class AccountCreateException extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;

	public AccountCreateException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}

