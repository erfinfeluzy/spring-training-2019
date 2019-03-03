package com.erfinfeluzy.training.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.erfinfeluzy.training.spring.model.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select * from tbl_customer where first_name like :firstname", 
	  nativeQuery = true)
	List<Customer> findAllCustomerNativeSQL(
			@Param("firstname") String firstname);
	
}
