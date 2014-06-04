package com.breakneck.bean;

import java.util.ArrayList;
import java.util.List;

import com.breakneck.model.Department;

/**
 * 
 * @author Madhulika
 *
 */

public class DepartmentBean {
	
	
	
	int deptId;
	
	String deptName;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	 public List<DepartmentBean> prepareListofBean(List<Department> departments){
		  List<DepartmentBean> beans = null;
		  if(departments != null && !departments.isEmpty()){
		   beans = new ArrayList<DepartmentBean>();
		   DepartmentBean bean = null;
		   for(Department department : departments){
		    bean = new DepartmentBean();
		    bean.setDeptName(department.getDeptName());
		    bean.setDeptId(department.getDeptId());
		     beans.add(bean);
		   }
		  }
		  return beans;
		 }
	  

}
