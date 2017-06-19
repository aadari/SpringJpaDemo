package com.example.springjpademo.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

/**
 * Created by Adi Adari on 1/1/2017.
 */

public interface EmployeeRepository<Employee, Integer> extends BaseRepository
{
   public Optional<Employee> findByLastName(String lastName);
   public Optional<List<Employee>> findByFirstName(String firstName);

   public void deleteByLastName(String lastName);

}
