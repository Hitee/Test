package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.bean.FlightBean;
import com.fms.dao.IFlightDao;
@Service
public class FlightServiceImpl implements IFlightService {

	
	//dao layer 
	@Autowired
	private IFlightDao fdao;
	
	@Override
	public int addFlightDetails(FlightBean f) {
		int b=fdao.addFlightDetails(f);
		System.out.println("in service "+b);
		return b;
	}

}
