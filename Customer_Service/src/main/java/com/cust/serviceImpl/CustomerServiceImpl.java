package com.cust.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.exceptions.CustomerIdNotFoundException;
import com.cust.exceptions.OrderIdNotFoundException;
import com.cust.model.Address;
import com.cust.model.Customer;
import com.cust.model.Orders;
import com.cust.repository.CustomerRepository;
import com.cust.repository.OrderRepository;
import com.cust.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Customer addCust(Customer c) {
		
		return repository.save(c);
	}

	@Override
	public Customer addAddr(Address adr, int cid) {
		
		Optional<Customer> opCust = repository.findById(cid);
		
		if(opCust.isEmpty())
		{
			throw new CustomerIdNotFoundException("Customer not found on id "+cid);
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
			throw new CustomerIdNotFoundException("Customer not found on id "+cid);
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

	@Override
	public Customer getCustomerById(int cid) {
		
		Optional<Customer> opCust = repository.findById(cid);
		
		if(opCust.isEmpty())
		{
			throw new CustomerIdNotFoundException("Customer not found on id "+cid);
		}
		else
		{
			return opCust.get();
		}
		
	}

	@Override
	public List<Orders> getAllOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public Orders getOrderById(int oid) {
		
		Optional<Orders> opOrder = orderRepository.findById(oid);
		
		if(opOrder.isEmpty())
		{
			throw new OrderIdNotFoundException("Order not found on id "+oid);
		}
		else
		{
			return opOrder.get();
		}
		
	}

	@Override
	public Customer updateOrder(int cid, int oid, Orders o) {
		
		Optional<Customer> opCust = repository.findById(cid);
		
		if(opCust.isEmpty())
		{
			throw new CustomerIdNotFoundException("Customer not found on id "+cid);
		}
		else
		{
			Customer c=opCust.get();
			c.getOrders().forEach(ord->{
				
				if(ord.getOrderId()==oid)
				{
					//ord.setOrderId(oid);
					ord.setOrderName(o.getOrderName());
					ord.setPrice(o.getPrice());
					//ord.setDate(o.getDate());
					ord.setPaymentType(o.getPaymentType());
				}
			});
			
			return repository.save(c);
		}
	
	}

	@Override
	public Customer deleteOrderById(int cid,int oid) {
		
		Optional<Customer> opCust = repository.findById(cid);
		if(opCust.isEmpty())
		{
			throw new CustomerIdNotFoundException("Customer not found on id "+cid);
		}
		else
		{
			Customer c=opCust.get();
//			c.getOrders().forEach(order->{
//				if(order.getOrderId()==oid)
//				{
//					Orders o=orderRepository.findById(oid).get();
//					c.getOrders().remove(o);
//					orderRepository.delete(o);
//				}
//			});
			
			Orders o=orderRepository.findById(oid).get();
			c.getOrders().remove(o);
			
			return repository.save(c);
		}
	}
	
}
