package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.model.Employee;


public interface EmployeeService {
 
 public void addEmployee(Employee employee);

 public List<Employee> listEmployeess();
 
 public Employee getEmployee(int empid);
 
 public void deleteEmployee(Employee employee);
}
