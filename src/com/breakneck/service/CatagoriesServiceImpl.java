package com.breakneck.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.breakneck.dao.CatagoriesDao;
import com.breakneck.model.Catagories;

/***
 * 
 * @author Madhulika
 *
 */

@Component
@Service("catagoriesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class CatagoriesServiceImpl implements CatagoriesService {
	
	 @Autowired
	  CatagoriesDao catagoriesDao;
	 
 public List<Catagories> listCatagories()
	  {
	
	  return catagoriesDao.listCatagories();

}
 public Catagories getCatagories(int catagoriesId)
 {
		  return catagoriesDao.getCatagory(catagoriesId);

	}
 public List<Catagories> getCatagoryListOfDepartment(int deptId){
	return catagoriesDao.getCatagoryListOfDepartment(deptId);
 }

}

