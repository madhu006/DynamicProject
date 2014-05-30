package com.breakneck.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.breakneck.model.Department;

/**
 * 
 * @author Madhulika
 *
 */

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	  SessionFactory sessionFactory;
	
	 
 @SuppressWarnings("unchecked")
public List<Department> listDepartment() {
	 return sessionFactory.getCurrentSession().createCriteria(Department.class).list();
}
	 
	 public Department getDepartment(int deptid) {
		 Session session = sessionFactory.openSession();	 
		 Department dept =(Department) session.get(Department.class, deptid);
		 session.close();
		  return dept;
	}


}
