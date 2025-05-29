package com.cust.service;

import java.util.List;

import com.cust.model.Address;
import com.cust.model.Customer;
import com.cust.model.Orders;

public interface CustomerService {

	public Customer addCust(Customer c);

	public Customer addAddr(Address adr, int cid);

	public Customer addOrder(Orders o, int cid);

	public List<Customer> getAllCustomers();

}
