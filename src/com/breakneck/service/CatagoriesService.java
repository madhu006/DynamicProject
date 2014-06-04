package com.breakneck.service;


import java.util.List;

import com.breakneck.model.Catagories;

public interface CatagoriesService {
	
	 public List<Catagories> listCatagories();
	 
	 public Catagories getCatagories(int deptid);

	 public List<Catagories> getCatagoryListOfDepartment(int deptId);

}

