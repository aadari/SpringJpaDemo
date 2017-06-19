package com.example.springjpademo.dao;

import java.util.List;

import com.example.springjpademo.entities.Employees;

/**
 * Created by Adi Adari on 12/30/2016.
 */
public interface EmployeeDAO
{
  Employees findById(Integer id);

  int deleteById(Integer id);
  
  void deleteByLastName(String lastName);

  List<Employees> findByFirstName(String firstNsame);
  
  List<Employees> findByLastName(String lastName);

  void save(Employees employee);
}
