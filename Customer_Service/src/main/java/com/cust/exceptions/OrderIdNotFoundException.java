package com.cust.exceptions;

public class OrderIdNotFoundException extends RuntimeException{
	
	public OrderIdNotFoundException(String msg) {
		super(msg);
	}

}
