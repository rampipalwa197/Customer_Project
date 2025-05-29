package com.cust.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.model.Address;
import com.cust.model.Customer;
import com.cust.model.Orders;
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

	@Override
	public Customer addAddr(Address adr, int cid) {
		
		Optional<Customer> opCust = repository.findById(cid);
		
		if(opCust.isEmpty())
		{
			throw new RuntimeException("Customer id not found");
		}
		else
		{
			Customer c=opCust.get();
			c.setAddress(adr);
			return repository.save(c);
		}
		
	}

	@Override
	public Customer addOrder(Orders o, int cid) {
		
		Optional<Customer> opCust = repository.findById(cid);
		
		if(opCust.isEmpty())
		{
			throw new RuntimeException("Customer id not found");
		}
		else
		{
			Customer c=opCust.get();
			c.getOrders().add(o);
		    return repository.save(c);	
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return repository.findAll();
	}
	
}
