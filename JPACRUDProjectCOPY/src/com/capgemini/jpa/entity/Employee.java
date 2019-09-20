package com.capgemini.jpa.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name="q1",query="select e from Employee e"),
		//@NamedQuery(name="q2",query="select e from Employee e where e.salary>45000.00")
		}
		)
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accno", length=30, nullable=false)
	private Integer accno;
	@Column(name="pin", length=30, nullable=false)
	private Integer pin;
	@Column(name="balance", length=30, nullable=false)
	private Double balance;
	@Column(name="ename", length=30, nullable=false)
	private String ename;
	@Column(name="transaction", length=30, nullable=false)
	private StringBuffer transaction = null ;
	
	
	//@NotNull

	
	
	public Integer getPin() {
		return pin;
	}

	public StringBuffer getTransaction() {
		return transaction;
	}

	public void setTransaction(StringBuffer transaction) {
		this.transaction = transaction;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Employee() {
		
	}

	

	public Integer getEmpid() {
		return accno;
	}

	public void setEmpid(Integer accno) {
		this.accno = accno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	
	

	public Integer getaccno() {
		return accno;
	}

	public void setaccno(Integer accno) {
		this.accno = accno;
	}

	public Employee(Integer accno, Integer pin, Double balance, String ename,
			StringBuffer transaction) {
		super();
		this.accno = accno;
		this.pin = pin;
		this.balance = balance;
		this.ename = ename;
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Employee [accno=" + accno + ", pin=" + pin + ", balance="
				+ balance + ", ename=" + ename + ", transaction=" + transaction
				+ "]";
	}

	

	
	

	
	

	
	
	
	
	
	
}
