package com.erfinfeluzy.training.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.erfinfeluzy.training.spring.model.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
