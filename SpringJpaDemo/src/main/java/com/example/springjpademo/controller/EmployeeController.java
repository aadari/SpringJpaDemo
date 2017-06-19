package com.example.springjpademo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpademo.HomeController;
import com.example.springjpademo.entities.Employees;
import com.example.springjpademo.exceptions.EmployeeNotFoundException;
import com.example.springjpademo.services.EmployeeService;


/**
 * Created by Adi Adari on 12/23/2016.
 */
@RestController
public class EmployeeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired(required=true)
    EmployeeService employeeService;

    
    @RequestMapping(value="/employee/{lastName}", method = RequestMethod.GET, headers="Accept=*/*",produces = "application/json")
    public List<Employees> findEmployeeByLastName(@PathVariable("lastName")  String lastName)
    {
    	List<Employees> employees = employeeService.findByLastName(lastName);
      if(employees.size() < 1)
   	  {
    	  throw new EmployeeNotFoundException(lastName);
   	  }
       return employees;
    }
    
    @RequestMapping(value="/employee/{firstName}", method = RequestMethod.GET, headers="Accept=*/*",produces = "application/json")
    public List<Employees> findByFirstName(@PathVariable("firstName") String firstName)
    {
    	List<Employees> employees = employeeService.findByFirstName(firstName);
      if(employees.size() < 1)
   	  {
    	  throw new EmployeeNotFoundException(firstName);
   	  }
       return employees;
    }
}

