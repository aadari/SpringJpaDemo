package com.example.springjpademo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.example.springjpademo.dao.EmployeeDAO;
import com.example.springjpademo.entities.Employees;
import com.example.springjpademo.services.EmployeeService;

//import junit.framework.Assert;

/**
 * Created by Adi Adari on 1/2/2017.
 */
@Component("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDAO employeeDAO;
	List<Employees> employees;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO
    		employeeDAO)
    {
    	//Assert.assertNotNull("Repository must not be null!", employeeRepository);
    	this.employeeDAO =  employeeDAO;
    }

 	public void deleteByLastName(String lastName)
    {
       employeeDAO.deleteByLastName(lastName);
    }

    public List<Employees> findByLastName(String lastName)
    {
    	try{
        employees = employeeDAO.findByLastName(lastName);
    	}
    	catch(DataAccessException dae)
    	{
    	  dae.getMessage();

    	}
        return employees;
    }

    public List<Employees> findByFirstName(String firstName)
    {
        List<Employees> employees = employeeDAO.findByFirstName(firstName);
        return employees;
    }
    
  /*  @Autowired(required=true)
    public void setEmployeeRepository(EmployeeRepository<Employee,Integer> employeeRepository)
    {
    	this.employeeRepository = employeeRepository;
    }*/
    
}
