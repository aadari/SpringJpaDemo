package com.example.springjpademo.services;

import java.util.List;

import com.example.springjpademo.entities.Employees;

/**
 * Created by Adi Adari on 1/1/2017.
 */

public interface EmployeeService
{
    void deleteByLastName(String lastName);
    List<Employees> findByFirstName(String firstName);
    List<Employees> findByLastName(String lastName);

}
