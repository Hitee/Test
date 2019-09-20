package com.deloitte.trg.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.trg.model.Customer;
import com.deloitte.trg.service.CustomerException;
import com.deloitte.trg.service.ICustomerService;
import com.deloitte.trg.utility.AppConfig;


@Controller
@RequestMapping(value="/cust")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	
	@RequestMapping(value="/cmenu")
	public String getCustomerMenu() {
		return "customer_menu";
	}
	
	@RequestMapping(value="prereg" ,method=RequestMethod.GET)
	public ModelAndView customerForm() {
		Customer customer=new Customer();
		return new ModelAndView("cust_reg","customer",customer);
	}

	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public ModelAndView addCustomer( @ModelAttribute(value="customer")Customer customer) {
		//System.out.println(customer.getCustomerName());
		try {
			String status=customerService.addCustomer(customer);
			return new ModelAndView("cust_status","message",status);
		} catch (CustomerException e) {			
			return new ModelAndView("status","message",e.getMessage());
		}		
	}
	
	@RequestMapping(value="/allc", method=RequestMethod.GET)
	public ModelAndView getAllCustomerDetails() {
		try {
			List<Customer> customerList=customerService.getAllCustomerDetails();
			if(customerList.size()!=0) {				
				return new ModelAndView("all_customers","customerList",customerList);
			}else {
				return new ModelAndView("cust_status","message","No customers in database");
			}
		}catch(CustomerException e) {
			e.printStackTrace();
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/preeditc", method=RequestMethod.GET)
	public ModelAndView preUpdateCustomer(@RequestParam(value="customerid") String customerid) {
		try {
			int id=Integer.parseInt(customerid);
			Customer customer=customerService.getCustomerById(id);
			return new ModelAndView("update_customer","customer",customer);
		}catch(CustomerException e) {
			return new ModelAndView("status","message",e.getMessage());
		}catch(Exception e) {
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/posteditc", method=RequestMethod.POST)
	public ModelAndView postUpdateCustomer(@ModelAttribute(value="customer") Customer customer) {
		try {
			//System.out.println(customer.getCustomerName());
			int n=customerService.updateCustomer(customer);
			if(n>0) {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.SUCCESS"));
			}else {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.FAIL"));
			}
		}catch(CustomerException e) {
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/deletec", method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam(value="customerid") String customerid) {
		try {
			int id=Integer.parseInt(customerid);
			int n= customerService.deleteCustomer(id);
			if(n>0) {
				return new ModelAndView("cust_status","message","Customer Record Deleted");
			}else {
				return new ModelAndView("cust_status","message","Unable to Delete Customer Record");
			}
		}catch(CustomerException e) {
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping("/status")
	public String goToCustomerMenu() {
		return "customer_menu";
	}
}
