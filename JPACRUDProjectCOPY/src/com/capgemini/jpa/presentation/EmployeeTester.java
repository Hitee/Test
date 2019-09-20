package com.capgemini.jpa.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;
import com.capgemini.jpa.service.EmployeeServiceImpl;
import com.capgemini.jpa.service.IEmployeeService;

public class EmployeeTester {
	private static IEmployeeService employeeService=
			new EmployeeServiceImpl();
	private static Scanner sc =  new Scanner(System.in);

	public static void main(String[] args) throws EmployeeException {

		while(true){
			System.out.println("1. Create account ");
			System.out.println("2. Show balance ");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transaction");
			System.out.println("7. Exit ");
			System.out.println("-------------------------------");
			System.out.println("Enter your choice: ");

			int option= sc.nextInt();
			switch(option){
			case 1:
				Employee employee1= new Employee();
				getEmployeeDetails(employee1);
				addNewEmployee(employee1);
				System.out.println(employee1);
				break;

			case 2:
				System.out.println("Enter the accno: ");
				Integer accno= sc.nextInt();
				System.out.println("Enter the pin: ");
				Integer pin= sc.nextInt();
				showEmployee(accno,pin);

				break;

			case 3:

				System.out.println("Enter the employee accno: ");
				Integer accno1= sc.nextInt();
				System.out.println("Enter the amount to be deposited: ");
				Double dep= sc.nextDouble();
				depositEmployee(accno1, dep);

				break;


			case 4:

				System.out.println("Enter the accno: ");
				Integer accno2= sc.nextInt();
				System.out.println("Enter the pin: ");
				Integer pin1= sc.nextInt();
				System.out.println("Enter the amount to be withdrawn: ");
				Double withdraw= sc.nextDouble();
				withdrawEmployee(accno2, withdraw, pin1);


				break;

			case 5:
				System.out.println("Enter your account number");
				Integer from = sc.nextInt();
				System.out.println("Enter the account number to which you want to transfer");
				Integer to = sc.nextInt();
				System.out.println("Enter amount to be transfered");
				Double transfer = sc.nextDouble();
				fundTransfer(from, to, transfer);


			case 6:
				System.out.println("Enter account number:");
				Integer accno3 = sc.nextInt();
				printTransaction(accno3);
				
			case 7:
				System.exit(0);
			default:
				System.out.println("Enter Proper option: (1-7)");

			}
		}

	}



	private static void depositEmployee(Integer accno, Double dep) {
		// TODO Auto-generated method stub
		try {
			employeeService.depositEmployee(accno, dep);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private static void withdrawEmployee(Integer accno, Double withdraw, Integer pin) {
		// TODO Auto-generated method stub
		try {
			employeeService.withdrawEmployee(accno, withdraw, pin);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private static void fundTransfer(Integer from, Integer to,  Double transfer) {
		// TODO Auto-generated method stub
		//employeeService.fundTransfer(from, to, transfer);
		try {
			employeeService.fundTransfer(from, to, transfer);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printTransaction(Integer accno) {
		// TODO Auto-generated method stub
		//employeeService.fundTransfer(from, to, transfer);
		try {
			employeeService.printTransaction(accno);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void showEmployee(Integer accno, Integer pin) {
		// TODO Auto-generated method stub
		try {
			employeeService.showEmployee(accno,pin);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getEmployeeDetails(Employee employee1) {

		System.out.println("Enter employee name:");
		employee1.setEname(sc.next());
		System.out.println("Enter balance");
		employee1.setBalance(sc.nextDouble());
		System.out.println("Enter account number: ");
		employee1.setaccno(sc.nextInt());
		System.out.println("Enter pin: ");
		employee1.setPin(sc.nextInt());
		StringBuffer sb = null;
		//sb.append("....");
		//employee1.setTransaction(sb);

	}

	private static void addNewEmployee(Employee employee) {
		try {
			employeeService.addNewEmployee(employee);
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}

	}

}
