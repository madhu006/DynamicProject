

package com.breakneck.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.breakneck.dao.EmployeeDaoImpl;
import com.breakneck.model.Employee;

/***
 * 
 * @author Madhulika
 *
 */

public class EmployeeDaoImplTest{

	@Before
	  public void setUp() { // Note: It is not required to call this setUp()
	    // ...
	  }
  @Test
  public void testListEmployee() {
	  EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();		
	 List<Employee> employeeList = employeeDaoImpl.listEmployeess();
	 assertNotNull(employeeList);
	 }

  @Test
  public void testGetEmployee() {
	  String str = "Baby Care";
	  EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();	
	  Employee employee = employeeDaoImpl.getEmployee(1);
	  assertEquals(employee.getEmpName(),str);
		}
} 