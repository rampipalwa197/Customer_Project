package com.cust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cust.model.Address;
import com.cust.model.Customer;
import com.cust.model.Orders;
import com.cust.service.CustomerService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@PutMapping("/addAddress/{cid}")
	public ResponseEntity<Customer> addAddress(@RequestBody Address adr,@PathVariable int cid)
	{
		Customer c=service.addAddr(adr,cid);
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@PutMapping("/addOrder/{cid}")
	public ResponseEntity<Customer> addOrder(@RequestBody Orders o,@PathVariable int cid)
	{
		Customer c=service.addOrder(o,cid);
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCust")
	public ResponseEntity<List<Customer>> getAllCust() {
		
		List<Customer> list=service.getAllCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
}
