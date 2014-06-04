package com.breakneck.bean;

import java.util.ArrayList;
import java.util.List;

import com.breakneck.model.Catagories;

public class CatagoriesBean {
	
	int catagoryId;
	
	String catagoryName;

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public int getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}
	
	 public List<CatagoriesBean> prepareListofCatagoriesBean(List<Catagories> catagoriesList){
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
