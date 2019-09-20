package com.deloitte.trg.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer_deloitte")
public class CustomerEntity {
	@Id
	@Column(name="customer_id")
	@SequenceGenerator(name="cust_jpa_seq_sg", sequenceName="customer_deloitte_seq",allocationSize=1)
	@GeneratedValue(generator="cust_jpa_seq_sg", strategy=GenerationType.SEQUENCE)
	private Integer customerId;
	@Column(name="customer_name")
	private String customerName;
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	private Long mobile;
	private String address;
	private String email;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	
	public String getCustomizedBirthdate() {
		SimpleDateFormat dateFormat=
						new SimpleDateFormat("dd-MM-yyyy");
		String sdate=dateFormat.format(this.birthdate);
		return sdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
