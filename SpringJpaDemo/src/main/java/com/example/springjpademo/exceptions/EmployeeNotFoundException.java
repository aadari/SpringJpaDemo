package com.example.springjpademo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found") //404
public class EmployeeNotFoundException extends RuntimeException 
{

	private static final long serialVersionUID = -3332292346834265371L;

	public EmployeeNotFoundException(String lastName)
	{
		super("EmployeeNotFoundException with name="+ lastName);
	}
	

}
