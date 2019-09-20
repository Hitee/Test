package com.capgemini.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;
import com.capgemini.jpa.utility.JPAUtil;

public class EmployeeDaoImpl implements IEmployeeDAO {
	private EntityManager entityManager= null;

	@Override
	public void addNewEmployee(Employee employee) throws EmployeeException {

		try{
			entityManager=JPAUtil.getEntityManager();
			//	entityManager =Persistence.createEntityManagerFactory("JPACRUDProject").createEntityManager();

			/*EntityTransaction transaction= entityManager.getTransaction();
			transaction.begin();*/  //this is same as below line entitymangaer.getTransaction().begin();
			/*StringBuffer sb = null;
			sb.append("Transaction: " + employee.getBalance());
			employee.setTransaction(sb);*/
			entityManager.getTransaction().begin();
			employee.setEmpid(null);
			entityManager.persist(employee); //add in table
			entityManager.getTransaction().commit();	
			//transaction.commit(); 
		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new EmployeeException(e.getMessage());
		}finally {
			entityManager.close();
		}

	}

	@Override
	public void showEmployee(Integer accno, Integer pin) throws EmployeeException {

		try{
			entityManager=JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			Employee employee= entityManager.find(Employee.class, accno);
			if(employee.getaccno() == accno && employee.getPin() == pin)
			{
				System.out.println("Account Balance is: " + employee.getBalance());
			}
			else
				System.out.println("Invalid Credentials");
			

			////entityManager.remove(employee);
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new EmployeeException(e.getMessage());
		}finally {
			entityManager.close();
		}


	}







	@Override
	public void depositEmployee(Integer accno, Double dep) throws EmployeeException {
		// TODO Auto-generated method stub
		try{
			entityManager=JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			Employee employee= entityManager.find(Employee.class, accno);
			Double present = employee.getBalance();
			present += dep; 
			employee.setBalance(present);
			entityManager.merge(employee);
			entityManager.getTransaction().commit();	

			System.out.println("Account Balance is: " + employee.getBalance());



		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new EmployeeException(e.getMessage());
		}finally {
			entityManager.close();
		}

	}

	@Override
	public void withdrawEmployee(Integer accno, Double withdraw ,Integer pin)
			throws EmployeeException {
		// TODO Auto-generated method stub
		try{
			entityManager=JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			Employee employee= entityManager.find(Employee.class, accno);
			
			if(employee.getaccno() == accno && employee.getPin() == pin)
			{
				Double present = employee.getBalance();
			present -= withdraw; 
			employee.setBalance(present);
			entityManager.merge(employee);
			entityManager.getTransaction().commit();	

			System.out.println("Account Balance is: " + employee.getBalance());

			}
			else
			System.out.println("Invalid Credentials");
			
			


		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new EmployeeException(e.getMessage());
		}finally {
			entityManager.close();
		}

	}

	@Override
	public void fundTransfer(Integer from, Integer to, Double transfer) throws EmployeeException {
		// TODO Auto-generated method stub
		try{
			entityManager=JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			//Employee employee= entityManager.find(Employee.class, accno);
			Employee employee_from = entityManager.find(Employee.class, from);
			Employee employee_to = entityManager.find(Employee.class, to);
			
			
			Double present_from = employee_from.getBalance();
			Double present_to = employee_to.getBalance();
			
			present_from -= transfer;
			present_to += transfer;
			employee_from.setBalance(present_from);
			employee_to.setBalance(present_to);
			
			entityManager.merge(employee_from);
			entityManager.merge(employee_to);
			
			entityManager.getTransaction().commit();	

			System.out.println("Account Balance(FROM) is: " + employee_from.getBalance());
			System.out.println("Account Balance(TO) is: " + employee_to.getBalance());



		}catch(PersistenceException e) {
			e.printStackTrace();
			//TODO: Log to file
			throw new EmployeeException(e.getMessage());
		}finally {
			entityManager.close();
		}
		
	}

	@Override
	public void printTransaction(Integer accno)
			throws EmployeeException {
		// TODO Auto-generated method stub
		
		
		
	}

}
