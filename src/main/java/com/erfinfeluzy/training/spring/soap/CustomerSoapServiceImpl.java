package com.erfinfeluzy.training.spring.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erfinfeluzy.training.spring.model.Customer;
import com.erfinfeluzy.training.spring.service.CustomerRepository;

@Service
public class CustomerSoapServiceImpl implements CustomerSoapService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		
		List<Customer> result = customerRepository.findAll();
		
		return result;
	}

	@Override
	public List<Customer> getCustomerByFirstname(String firstname) {
		
		List<Customer> result = customerRepository.findAllCustomerNativeSQL(firstname);
				
		return result;
	}

}
