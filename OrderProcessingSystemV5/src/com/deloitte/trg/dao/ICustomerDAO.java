package com.deloitte.trg.dao;

import java.util.List;

import com.deloitte.trg.entity.CustomerEntity;
import com.deloitte.trg.service.CustomerException;



public interface ICustomerDAO {
	public abstract String addCustomer(CustomerEntity customer) throws CustomerException;
	public abstract List<CustomerEntity> getAllCustomerDetails() throws CustomerException;
	public abstract CustomerEntity getCustomerById(Integer ID) throws CustomerException;
	public abstract Integer deleteCustomer(Integer ID) throws CustomerException;
	public abstract Integer updateCustomer(CustomerEntity customer) throws CustomerException;
}
