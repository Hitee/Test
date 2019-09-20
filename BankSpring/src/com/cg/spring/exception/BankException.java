
package com.cg.spring.exception;

public class BankException extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;

	public BankException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
