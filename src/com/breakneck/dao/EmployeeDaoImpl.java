package com.breakneck.dao;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.breakneck.model.Employee;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

 @Autowired
  SessionFactory sessionFactory;
 
 @Override
public void addEmployee(Employee employee) {
	 try {
   sessionFactory.getCurrentSession().saveOrUpdate(employee);
	 }
	 catch(RuntimeException e){
		 sessionFactory.getCurrentSession().getTransaction().commit();
	 }	
 }

 @Override
@SuppressWarnings("unchecked")
 public List<Employee> listEmployeess() {
  return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
 }

 @Override
public Employee getEmployee(int empid) {
  return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
 }

 @Override
public void deleteEmployee(Employee employee) {
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
 }
}