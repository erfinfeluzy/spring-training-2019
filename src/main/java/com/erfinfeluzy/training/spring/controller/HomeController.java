package com.erfinfeluzy.training.spring.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erfinfeluzy.training.spring.model.Customer;
import com.erfinfeluzy.training.spring.service.CustomerRepository;

@Controller
public class HomeController {
	
	
	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		System.out.println("masuk : / ");
		
		return "home";
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public String customerAdd() {
		
		System.out.println("/customer/add");
		
		Customer cust = new Customer();
		cust.setFirstName("erfin");
		cust.setLastName("feluzy");
		cust.setBirthdate(new Date());
		cust.setUsername("erfinfeluzy");
		
		customerRepository.save(cust);
		
		return "add_customer";
	}
	
	@RequestMapping(value = "/customer/all", method = RequestMethod.GET)
	public String customerList(Model model) {
		
		List<Customer> customers = customerRepository.findAll();
		
		model.addAttribute("customers", customers);
		
		return "customers";
	}
	
	@RequestMapping(value = "/customer/firstname/{firstname}", method = RequestMethod.GET)
	public String findByFirstname (
			Model model, 
			@PathVariable String firstname) {
		
		System.out.println("firstname: " + firstname);
		
		firstname = firstname + "%";
		
		List<Customer> customers = customerRepository.findAllCustomerNativeSQL(firstname);
		
		model.addAttribute("customers", customers);
		
		return "customers";
	}
	
}
