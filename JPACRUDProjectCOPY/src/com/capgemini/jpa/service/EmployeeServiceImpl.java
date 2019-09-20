package com.capgemini.jpa.service;

import java.util.List;

import com.capgemini.jpa.dao.EmployeeDaoImpl;
import com.capgemini.jpa.dao.IEmployeeDAO;
import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDAO employeeDAO=new EmployeeDaoImpl();

	@Override
	public void addNewEmployee(Employee employee) throws EmployeeException {
		employeeDAO.addNewEmployee(employee);

	}

	@Override
	public void showEmployee(Integer accno, Integer pin) throws EmployeeException {
		// TODO Auto-generated method stub
		employeeDAO.showEmployee(accno, pin);
	}



	@Override
	public void depositEmployee(Integer accno, Double dep) throws EmployeeException {
		// TODO Auto-generated method stub
		employeeDAO.depositEmployee(accno, dep);
	}

	@Override
	public void withdrawEmployee(Integer accno, Double withdraw, Integer pin)
			throws EmployeeException {
		// TODO Auto-generated method stub
		employeeDAO.withdrawEmployee(accno, withdraw, pin);

	}

	@Override
	public void fundTransfer(Integer from, Integer to, Double transfer) throws EmployeeException {
		// TODO Auto-generated method stub
		employeeDAO.fundTransfer(from, to, transfer);
	}

	@Override
	public void printTransaction(Integer accno)
			throws EmployeeException {
		// TODO Auto-generated method stub
		employeeDAO.printTransaction(accno);
		
	}

}
