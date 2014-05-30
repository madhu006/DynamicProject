package com.breakneck.service;

import java.util.List;

import com.breakneck.model.Department;

public interface DepartmentService {
	
	 public List<Department> listDepartment();
	 
	 public Department getDepartment(int deptid);


}
