package com.deloitte.trg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.trg.dao.ICustomerDAO;
import com.deloitte.trg.entity.CustomerEntity;
import com.deloitte.trg.model.Customer;

@Service
@Transactional
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	
	@Override
	public String addCustomer(Customer customer) throws CustomerException {
		CustomerValidator validator=new CustomerValidator();
		if(validator.validate(customer)) {			
			CustomerEntity customerEntity=new CustomerEntity();
			populateCustomerEntity(customer,customerEntity);
			String  status=customerDAO.addCustomer(customerEntity);
			return status;
		}else {
			return "Invalid Customer Details";
		}
		
		
	}

	private void populateCustomerEntity(Customer customer, CustomerEntity customerEntity) {
		customerEntity.setCustomerId(customer.getCustomerId());
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setMobile(customer.getMobile());
		customerEntity.setAddress(customer.getAddress());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setBirthdate(customer.getBirthdate());
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		try {
			List<CustomerEntity> customerEntityList=customerDAO.getAllCustomerDetails();
			//System.out.println(customerEntityList.size());
			
			if(customerEntityList !=null) {
				List<Customer> customerList=new ArrayList<>();				
				populateCustomerList(customerList,customerEntityList);
				return customerList;
			}
			throw new CustomerException("Customer List is empty");
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		
	}

	private void populateCustomerList(List<Customer> customerList, List<CustomerEntity> customerEntityList) {
		Iterator<CustomerEntity> iterator= customerEntityList.iterator();		
		while(iterator.hasNext()) {
			Customer customer=new Customer();
			populateCustomer(customer,iterator.next());
			customerList.add(customer);		
		}
		
	}

	private void populateCustomer(Customer customer, CustomerEntity next) {
		customer.setCustomerId(next.getCustomerId());
		customer.setCustomerName(next.getCustomerName());
		customer.setBirthdate(next.getBirthdate());
		customer.setAddress(next.getAddress());
		customer.setMobile(next.getMobile());
		customer.setEmail(next.getEmail());		
	}

	@Override
	public Customer getCustomerById(Integer ID) throws CustomerException {
		CustomerEntity customerEntity=customerDAO.getCustomerById(ID);
		if(customerEntity!=null) {
			Customer customer=new Customer();
			populateCustomer(customer,customerEntity);
			return customer;
		}
		return null;
	}

	@Override
	public Integer deleteCustomer(Integer ID) throws CustomerException {
		return customerDAO.deleteCustomer(ID);
	}

	@Override
	public Integer updateCustomer(Customer customer) throws CustomerException {
		CustomerEntity customerEntity=new CustomerEntity();
		populateCustomerEntity(customer,customerEntity);
		return customerDAO.updateCustomer(customerEntity);
	}

	

}
