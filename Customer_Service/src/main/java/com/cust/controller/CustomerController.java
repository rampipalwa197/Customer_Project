package com.cust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cust.model.Customer;
import com.cust.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@PostMapping("/postCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer c)
	{
		Customer cust=service.addCust(c);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
}
