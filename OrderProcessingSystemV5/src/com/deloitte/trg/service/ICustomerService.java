package com.deloitte.trg.service;

import java.util.List;

import com.deloitte.trg.model.Customer;


public interface ICustomerService {
	public abstract String addCustomer(Customer customer) throws CustomerException;
	public abstract List<Customer> getAllCustomerDetails() throws CustomerException;
	public abstract Customer getCustomerById(Integer ID) throws CustomerException;
	public abstract Integer deleteCustomer(Integer ID) throws CustomerException;
	public abstract Integer updateCustomer(Customer customer) throws CustomerException;
}
