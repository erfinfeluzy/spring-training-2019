package com.erfinfeluzy.training.spring.soap;

import java.util.List;

import javax.jws.WebService;

import com.erfinfeluzy.training.spring.model.Customer;

@WebService(serviceName = "InfoService")
public interface CustomerSoapService {

	
	List<Customer> getAllCustomer();
	
	List<Customer> getCustomerByFirstname(String firstname);
	
}
