package com.capgemini.jpa.dao;

import java.util.List;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;

public interface IEmployeeDAO {
	public abstract void addNewEmployee(Employee employee) throws EmployeeException;//
	public abstract void showEmployee(Integer accno, Integer pin) throws EmployeeException;//
	public abstract void depositEmployee(Integer accno, Double dep) throws EmployeeException;//
	public abstract void withdrawEmployee(Integer accno, Double withdraw , Integer pin) throws EmployeeException;//
	public abstract void fundTransfer(Integer from, Integer to, Double transfer) throws EmployeeException;//
	public abstract void printTransaction(Integer accno) throws EmployeeException;//
	
}
