package com.cust.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cust.exceptions.CustomerIdNotFoundException;
import com.cust.exceptions.OrderIdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<String> customerIdException(CustomerIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<String> orderIdException(OrderIdNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validException(MethodArgumentNotValidException e)
	{
		Map<String, String> errors=new HashMap<String, String>();
		
		e.getBindingResult().getFieldErrors().forEach(error->{
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
