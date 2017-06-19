package com.example.springjpademo.dao;

import java.util.List;

/**
 * Created by Adi Adari on 12/30/2016.
 */
public interface DepartmentDAO<T>
{
   void deleteById(Integer deptId);

   List<T> findByName(String name);
   
   
}
