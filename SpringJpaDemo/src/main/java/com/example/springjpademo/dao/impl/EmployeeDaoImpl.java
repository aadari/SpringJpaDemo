package com.example.springjpademo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.springjpademo.dao.EmployeeDAO;
import com.example.springjpademo.entities.Employees;

@Repository("EmployeeDAO")
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDAO 
{
    
	@Override
	public Employees findById(Integer id)
	{
	    	
		return (Employees) getSession().get(Employees.class, id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public int deleteById(Integer id) 
	{
		String sql = "delete * from Employees where employeeId =:id"; 
		Query query = getSession().createQuery(sql);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	@Override
	public List<Employees> findByFirstName(String name) 
	{
		Query query = getSession().createQuery("select * from Employees where firstName =:name");
		query.setParameter("name", name);
		return query.list();
	}
	
	@Override
	public List<Employees> findByLastName(String lastName)
	{

		Query query = getSession().createQuery("from Employees where lastName =:lastName");
		query.setParameter("lastName", lastName);
		return query.list();
		

	}
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteByLastName(String lastName)
	{
		List<Employees> employees = findByLastName(lastName);
	       if(!employees.isEmpty())
	        {
	    	   Employees employeeEntity = employees.get(0);
	           delete(employeeEntity);
	        }
	}
	
	

	@Override
	public void save(Employees employee) 
	{

       persist(employee);
	}

}
