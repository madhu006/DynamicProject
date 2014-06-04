package com.breakneck.dao;



import java.util.List;

import com.breakneck.model.Catagories;

public interface CatagoriesDao {
	
	 public List<Catagories> listCatagories();
	 
	 public Catagories getCatagory(int catagoriesId);
	 
	 public List<Catagories> getCatagoryListOfDepartment(int deptId);



}
