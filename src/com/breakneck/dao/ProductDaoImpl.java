

package com.breakneck.dao;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.breakneck.model.Catagories;
import com.breakneck.model.Employee;
import com.breakneck.model.Product;


@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

 @Autowired
  SessionFactory sessionFactory;
 

 
 @Override
 public void addProduct(Product product) {
 	 try {
 		 Session session =sessionFactory.openSession();
 		 
 		Transaction transaction = session.beginTransaction();
 		session.saveOrUpdate(product);
 	transaction.commit();
 	session.close();
 	 }
 	 catch(RuntimeException e){
 	//	 sessionFactory.getCurrentSession().getTransaction().commit();
 	 }	
  }

 @Override
@SuppressWarnings("unchecked")
 public List<Product> listProducts(){
	 Session session =  sessionFactory.getCurrentSession();
  return session.createCriteria(Product.class).list();
 }

 @Override
 public Product getProduct(int id){
  return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
 }

 @Override
 public void deleteProduct(Product product){
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE product_id = "+product.getProductId()).executeUpdate();
 }
 @SuppressWarnings("unchecked")
	
 public List<Product> getProductListByName(String search){
	 Session session = sessionFactory.getCurrentSession();	 
	List<Product> productList = session.createCriteria(Product.class).add(Restrictions.ilike("productName",search , MatchMode.ANYWHERE)).list();
//	 session.close();
	  return productList;

 }
}
