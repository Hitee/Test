package com.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FlightBean {

	@Id
	@GeneratedValue
	private Integer flightId;
	private String flightName;
	private String classtype;
	public FlightBean() {
		// TODO Auto-generated constructor stub
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public FlightBean(Integer flightId, String flightName, String classtype) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.classtype = classtype;
	}
	public FlightBean( String flightName, String classtype) {
		this.flightName = flightName;
		this.classtype = classtype;
	}
	
	
	
	
}
