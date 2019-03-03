package com.erfinfeluzy.training.spring;

import java.util.List;

import com.erfinfeluzy.training.model.Customer;
import com.erfinfeluzy.training.spring.service.CustomerService;

public class SpringDI {
	
	
	CustomerService customerService;

	public List<Customer> getAllCustomers(){
		
		return customerService.getAllCustomersFromDB();
		
		
	}
	
}
