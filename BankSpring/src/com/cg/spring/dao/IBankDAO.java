package com.cg.spring.dao;

import java.util.ArrayList;

import com.cg.spring.exception.BankBalanceException;
import com.cg.spring.exception.AccountCreateException;
import com.cg.spring.exception.BankException;
import com.cg.spring.model.Account;

public interface IBankDAO {
	public int addAccount(Account acc) throws AccountCreateException;

	public int depositMoney(int accNumber, int money) throws BankException;

	public int withdrawMoney(int accNumber, int money) throws BankException, BankBalanceException;

	public String fundTransfer(int accNumber, int receiverAccNumber, int money)
			throws BankException, BankBalanceException;

	public ArrayList<String> showTransactions(int accNumber);

	public int showBalance(int accNumber) throws BankException;

	public Account showDetails(int accHolder) throws BankException;
}
