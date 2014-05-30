package com.breakneck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.breakneck.dao.DepartmentDao;
import com.breakneck.model.Department;

/***
 * 
 * @author Madhulika
 *
 */

@Component
@Service("departmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class DepartmentServiceImpl implements DepartmentService {
	
	 @Autowired
	  DepartmentDao departmentDao;
	 

 public List<Department> listDepartment() {
	
	  return departmentDao.listDepartment();

}
	 
	 public Department getDepartment(int deptid) {
		  return departmentDao.getDepartment(deptid);

	}

}
