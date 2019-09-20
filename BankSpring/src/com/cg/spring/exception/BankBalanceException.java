package com.cg.spring.exception;

public class BankBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;

	public BankBalanceException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}