package com.erfinfeluzy.training;

import java.util.List;

import com.erfinfeluzy.training.model.Customer;
import com.erfinfeluzy.training.spring.SpringDI;

public class Application {

	
	public static void main(String[] args) {
		
		
		System.out.println("hello");
		
		SpringDI withoutSpring = new SpringDI();
		
		List<Customer> customers =  withoutSpring.getAllCustomers();
		
	}
	
}
