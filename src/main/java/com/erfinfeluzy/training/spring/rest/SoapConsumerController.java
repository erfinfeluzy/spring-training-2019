package com.erfinfeluzy.training.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erfinfeluzy.training.spring.model.Customer;
import com.erfinfeluzy.training.spring.soap.CustomerSoapService;

@RestController
@RequestMapping("/api")
public class SoapConsumerController {

	@Autowired
	@Qualifier("client")
	private CustomerSoapService customerSoapService;
	
	
	@GetMapping(value = "/customers")
	public ResponseEntity<?> getAllCustomersFromWebService() {
		
		System.out.println("SOAP consumer has been called by utilizing REST");
		
		List<Customer> customers = customerSoapService.getAllCustomer();
		
		return ResponseEntity.ok(customers);
	}
	
	
	@GetMapping(value = "/customer/{firstname}")
	public ResponseEntity<?> getCustomerByFirstnameFromWebService(@PathVariable String firstname) {
		
		System.out.println("SOAP consumer has been called by utilizing REST");
		
		List<Customer> customers = customerSoapService.getCustomerByFirstname(firstname);
		
		return ResponseEntity.ok(customers);
	}
	
}
