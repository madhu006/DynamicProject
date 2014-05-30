package com.breakneck.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.breakneck.bean.DepartmentBean;
import com.breakneck.model.Department;
import com.breakneck.service.DepartmentService;
/**
 * 
 * @author Madhulika
 *
 */

@Controller
public class DepartmentController {
	 @Autowired
	 DepartmentService departmentService;
	/* 
	 @RequestMapping(value = "/template", method = RequestMethod.GET)
	   public String printTemplate(ModelMap model) {
	      model.addAttribute("message", "Body Template Spring MVC Framework!");

	      return "template";
	   }
	   */

	 @RequestMapping(value="/template", method = RequestMethod.GET)
	 public ModelAndView listDepartmentContol() {
	  Map<String, Object> model = new HashMap<String ,Object>();
	  model.put("departments",  listDepartment());
	  return new ModelAndView("template", model);
	 }
	 
	 public ArrayList<String> listDepartment(){
		  ArrayList<String> departmentNameList = new ArrayList<String>();
		List<Department> departmentList = departmentService.listDepartment();
		List<DepartmentBean> departmentBeanList = prepareListofBean(departmentList);
		for(DepartmentBean departmentBean : departmentBeanList){
			departmentNameList.add(departmentBean.getDeptName());
		}
		return departmentNameList;		
	}
	
	 private List<DepartmentBean> prepareListofBean(List<Department> departments){
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
