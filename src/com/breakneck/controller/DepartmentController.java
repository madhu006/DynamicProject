package com.breakneck.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.breakneck.bean.CatagoriesBean;
import com.breakneck.bean.DepartmentBean;
import com.breakneck.bean.ProductBean;
import com.breakneck.model.Catagories;
import com.breakneck.model.Department;
import com.breakneck.model.Product;
import com.breakneck.service.CatagoriesService;
import com.breakneck.service.DepartmentService;
import com.breakneck.service.ProductService;
/**
 * 
 * @author Madhulika
 *
 */

@Controller
public class DepartmentController {
	 @Autowired
	 DepartmentService departmentService;
	 
	 @Autowired
	 CatagoriesService catagoriesService;
	
	 
	 @Autowired
	 ProductService productService;
	 
	 Map<String, Object> model = new HashMap<String ,Object>();
	 
	 
	
	
	/* 
	 @RequestMapping(value = "/template", method = RequestMethod.GET)
	   public String printTemplate(ModelMap model) {
	      model.addAttribute("message", "Body Template Spring MVC Framework!");

	      return "template";
	   }
	   */

	 @RequestMapping(value="/template", method = RequestMethod.GET)
	 public ModelAndView listDepartmentContol() {
	//  Map<String, Object> model = new HashMap<String ,Object>();
	  List<Department> departmentList = departmentService.listDepartment();
	//	List<DepartmentBean> departmentBeanList = prepareListofBean(departmentList);
	  List<DepartmentBean> listDepartmentBean= prepareListofBean(departmentList);
	  model.put("departments",  listDepartmentBean);
		List<Catagories> catagoriesList = catagoriesService.listCatagories();		
	  model.put("catagories",  prepareListofCatagoriesBean(catagoriesList));
	  
	  Map<DepartmentBean,List<CatagoriesBean>> departmentCatagoriesMap =
			  new HashMap<DepartmentBean,List<CatagoriesBean>>();
	  for(DepartmentBean departmentBean : listDepartmentBean){
	   List<Catagories> listOfDepartmentsPerCatogory =catagoriesService.getCatagoryListOfDepartment( departmentBean.getDeptId());
	   List<CatagoriesBean> listOfDepartmentsBeansPerCatogory= prepareListofCatagoriesBean(listOfDepartmentsPerCatogory);
	   departmentCatagoriesMap.put(departmentBean, listOfDepartmentsBeansPerCatogory);
	  }
	  model.put("departmentToCatagories",  departmentCatagoriesMap);
		
	  return new ModelAndView("template", model);
	 }
	 
	 @RequestMapping(value = "/template", method = RequestMethod.POST) 
	 public ModelAndView searchPrductByName( @RequestParam String search) {
		 List<Product> listOfProductByName =productService.getProductList(search);
	//	  Map<String, Object> model = new HashMap<String ,Object>();
		  List<ProductBean> productBeanList = prepareListofProductBean(listOfProductByName);
		  model.put("productBean", productBeanList);
			
			   return new ModelAndView("template",model);
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
	 
	 private List<ProductBean> prepareListofProductBean(List<Product> products){
		  List<ProductBean> beans = null;
		  if(products != null && !products.isEmpty()){
		   beans = new ArrayList<ProductBean>();
		   ProductBean bean = null;
		   for(Product product : products){
		    bean = new ProductBean();
		    bean.setCatagoryId(product.getCatagoryId());
		    bean.setProductId(product.getProductId());
		    bean.setCode(product.getProductCode());
		    bean.setPrice(product.getPrice());
		    bean.setProductDetail(product.getProductDetails());
		    bean.setFileLocation(product.getFileLocation());
		    bean.setName(product.getProductName());
		    bean.setQuantity(product.getProductQuantity());
		    bean.setWeight(product.getProductWeight());
		    bean.setSupplierCode(product.getSupplierCode());
			 beans.add(bean);
		   }
		  }
		  return beans;
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
	 
	 public ArrayList<String> listCatagories(){
		  ArrayList<String> catagoriesNameList = new ArrayList<String>();
		List<Catagories> catagoriesList = catagoriesService.listCatagories();
		List<CatagoriesBean> catagoriesBeanList = prepareListofCatagoriesBean(catagoriesList);
		for(CatagoriesBean catagoriesBean : catagoriesBeanList){
			catagoriesNameList.add(catagoriesBean.getCatagoryName());
		}
		return catagoriesNameList;		
	}
	
	 private List<CatagoriesBean> prepareListofCatagoriesBean(List<Catagories> catagoriesList){
		  List<CatagoriesBean> beans = null;
		  if(catagoriesList != null && !catagoriesList.isEmpty()){
		   beans = new ArrayList<CatagoriesBean>();
		   CatagoriesBean bean = null;
		   for(Catagories catagory : catagoriesList){
		    bean = new CatagoriesBean();
		    bean.setCatagoryName(catagory.getCategory_Name());
		    bean.setCatagoryId(catagory.getCategory_Id());
		     beans.add(bean);
		   }
		  }
		  return beans;
		 }
		 
	 
	 
}
