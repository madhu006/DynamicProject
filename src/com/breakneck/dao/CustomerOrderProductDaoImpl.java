


package com.breakneck.dao;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.breakneck.bean.CustomerOrderProductBean;


@Repository("customerOrderProductDao")
public class CustomerOrderProductDaoImpl implements CustomerOrderProductDao {

 @Autowired
  SessionFactory sessionFactory;
 

@Override
public void addCustomerOrderProduct(
		CustomerOrderProductBean customerOrderProduct) {
	// TODO Auto-generated method stub
	
	 try {
 		 Session session =sessionFactory.openSession();
 		 
 		Transaction transaction = session.beginTransaction();
 		session.saveOrUpdate(customerOrderProduct);
 	transaction.commit();
 	session.close();
 	 }
 	 catch(RuntimeException e){
 	//	 sessionFactory.getCurrentSession().getTransaction().commit();
 	 }	
	
	
}

@SuppressWarnings("unchecked")
@Override
public List<CustomerOrderProductBean> listCustomerOrderProduct() {
	// TODO Auto-generated method stub
	 Session session =  sessionFactory.getCurrentSession();
	  return session.createCriteria(CustomerOrderProductBean.class).list();
	 
}

@Override
public CustomerOrderProductBean getCustomerOrderProduct(int id) {
	// TODO Auto-generated method stub
	  return (CustomerOrderProductBean) sessionFactory.getCurrentSession().get(CustomerOrderProductBean.class, id);

		
}

@Override
public void deleteCustomer(CustomerOrderProductBean customerOrderProduct) {
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM customer_orders_products WHERE order_id = "+customerOrderProduct.getOrderId()).executeUpdate();

}
}
