package com.cust.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.model.Customer;
import com.cust.repository.CustomerRepository;
import com.cust.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repository;

	@Override
	public Customer addCust(Customer c) {
		
		return repository.save(c);
	}
	
}
