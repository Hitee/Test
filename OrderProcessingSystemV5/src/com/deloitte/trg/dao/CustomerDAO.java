package com.deloitte.trg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.deloitte.trg.entity.CustomerEntity;
import com.deloitte.trg.service.CustomerException;
import com.deloitte.trg.utility.AppConfig;

@Repository
public class CustomerDAO implements ICustomerDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String addCustomer(CustomerEntity customer) throws CustomerException {
		Logger myLogger=Logger.getLogger(CustomerDAO.class);
		try {
			entityManager.persist(customer);
			myLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_INSERT.SUCCESS"));
			return AppConfig.PROPERTIES.getProperty("CUSTOMER_INSERT.SUCCESS");
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage());
		}		
	}

	@Override
	public List<CustomerEntity> getAllCustomerDetails() throws CustomerException {
		final Logger myLogger = Logger.getLogger(CustomerDAO.class);			
		String sql="From CustomerEntity";
		//EntityTransaction transaction=entityManager.getTransaction();
		try {
			//transaction.begin();
			Query query=entityManager.createQuery(sql);
			List<CustomerEntity> customerList=query.getResultList();			
			//transaction.commit();
			myLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_READALL.SUCCESS"));
			return customerList;
		}catch(PersistenceException e) {			
			myLogger.error(e.getMessage());		
			throw new CustomerException(e.getMessage());
		}catch(Exception e) {	
			myLogger.error(e.getMessage());
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public CustomerEntity getCustomerById(Integer ID) throws CustomerException {
		Logger myLogger=Logger.getLogger(CustomerDAO.class);
		try {
			 CustomerEntity customerEntity=entityManager.find(CustomerEntity.class, ID);
			 myLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_READ.SUCCESS"));
			 return customerEntity;
		}catch(PersistenceException e) {			
			myLogger.error(e.getMessage());		
			throw new CustomerException(e.getMessage());
		}catch(Exception e) {	
			myLogger.error(e.getMessage());
			throw new CustomerException(e.getMessage());
		}
	}

	@Override
	public Integer deleteCustomer(Integer ID) throws CustomerException {
		Logger myLogger=Logger.getLogger(CustomerDAO.class);
		try {
			CustomerEntity customer=entityManager.find(CustomerEntity.class, ID);
			entityManager.remove(customer);
			myLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_DELETE.SUCCESS"));
			return 1;
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage());
		}	
	}

	@Override
	public Integer updateCustomer(CustomerEntity customer) throws CustomerException {
		Logger myLogger=Logger.getLogger(CustomerDAO.class);
		try {
			entityManager.merge(customer);
			myLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.SUCCESS"));
			return 1;
		}catch(PersistenceException e) {
			throw new CustomerException(e.getMessage());
		}	
	}

}
