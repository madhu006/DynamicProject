package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.breakneck.dao.EmployeeDao;
import com.breakneck.model.Employee;

@Component
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
  EmployeeDao employeeDao;
 
 @Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addEmployee(Employee employee) {
  employeeDao.addEmployee(employee);
 }
 
 @Override
public List<Employee> listEmployeess() {
  return employeeDao.listEmployeess();
 }

 @Override
public Employee getEmployee(int empid) {
  return employeeDao.getEmployee(empid);
 }
 
 @Override
public void deleteEmployee(Employee employee) {
  employeeDao.deleteEmployee(employee);
 }

}
