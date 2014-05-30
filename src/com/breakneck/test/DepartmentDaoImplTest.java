package com.breakneck.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.breakneck.dao.DepartmentDaoImpl;
import com.breakneck.model.Department;

/***
 * 
 * @author Madhulika
 *
 */

@RunWith( SpringJUnit4ClassRunner.class )
@org.springframework.context.annotation.Configuration
@ContextConfiguration(locations="classpath:resources/applicationContext.xml")

public class DepartmentDaoImplTest{
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 private Session session = null;
	 @Autowired
	 DepartmentDaoImpl departmentDaoImpl;
	
	 
  @SuppressWarnings("unchecked")
@Test
  public void testListDepartment() {
	  session = sessionFactory.openSession();
	  session.beginTransaction();
	  
	 List<Department> departmentList = session.createCriteria(Department.class).list();
		//	 departmentDaoImpl.listDepartment();
	 session.close();
	 assertNotNull(departmentList);
	 }

  @Test
  
  public void testGetDepartment() {
	  session = sessionFactory.openSession();
	  session.beginTransaction();  	
	  sessionFactory = session.getSessionFactory();
	  String str = "Baby Care";
	  Department department = departmentDaoImpl.getDepartment(1);
	  session.close();
	  assertEquals(department.getDeptName(),str);
		}
  
} 