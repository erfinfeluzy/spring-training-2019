package com.erfinfeluzy.training.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthdate;
	
	
	
}
