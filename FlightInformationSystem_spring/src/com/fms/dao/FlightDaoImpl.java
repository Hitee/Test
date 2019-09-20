package com.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fms.bean.FlightBean;
@Repository
@Transactional
public class FlightDaoImpl implements IFlightDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int  addFlightDetails(FlightBean f) {
		System.out.println("in dao");
		em.persist(f);
		System.out.println(f.getFlightId());
		return f.getFlightId();
	}

}
