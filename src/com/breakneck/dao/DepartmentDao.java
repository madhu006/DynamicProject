package com.breakneck.dao;

import java.util.List;

import com.breakneck.model.Department;

public interface DepartmentDao {
	
	 public List<Department> listDepartment();
	 
	 public Department getDepartment(int deptid);


}
