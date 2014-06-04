


package com.breakneck.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.breakneck.model.Catagories;

/**
 * 
 * @author Madhulika
 *
 */

@Repository("catagoriesDao")
public class CatagoriesDaoImpl implements CatagoriesDao {
	
	@Autowired
	  SessionFactory sessionFactory;
	
 @SuppressWarnings("unchecked")
public List<Catagories> listCatagories() {
	 return sessionFactory.getCurrentSession().createCriteria(Catagories.class).list();
}
 public Catagories getCatagory(int catagoriesId) {
		 Session session = sessionFactory.openSession();	 
		 Catagories catagory =(Catagories) session.get(Catagories.class, catagoriesId);
		 session.close();
		  return catagory;
	}
 
 @SuppressWarnings("unchecked")
public List<Catagories> getCatagoryListOfDepartment(int deptId){
	 Session session = sessionFactory.openSession();	 
	 List<Catagories> catagoryList = session.createCriteria(Catagories.class).add(Restrictions.like("dept_Id", deptId)).list();
	 session.close();
	  return catagoryList;

 }


}

