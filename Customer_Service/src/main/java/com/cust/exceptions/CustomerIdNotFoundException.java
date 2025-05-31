package com.cust.exceptions;

public class CustomerIdNotFoundException extends RuntimeException{
	
	public CustomerIdNotFoundException(String msg) {
		super(msg);
	}

}
