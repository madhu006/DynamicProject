




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
import com.breakneck.bean.CustomerPaymentBean;


@Repository("customerPaymentDao")
public class CustomerPaymentDaoImpl implements CustomerPaymentDao {

 @Autowired
  SessionFactory sessionFactory;
 


@Override
public void addCustomerPayment(CustomerPaymentBean customerPaymentBean) {
	// TODO Auto-generated method stub
	
	 try {
 		 Session session =sessionFactory.openSession();
 		 
 		Transaction transaction = session.beginTransaction();
 		session.saveOrUpdate(customerPaymentBean);
 	transaction.commit();
 	session.close();
 	 }
 	 catch(RuntimeException e){
 	//	 sessionFactory.getCurrentSession().getTransaction().commit();
 	 }	
	
	
}

@SuppressWarnings("unchecked")
@Override
public List<CustomerPaymentBean> listCustomerPayment() {
	// TODO Auto-generated method stub
	 Session session =  sessionFactory.getCurrentSession();
	  return session.createCriteria(CustomerPaymentBean.class).list();
	
}

@Override
public CustomerPaymentBean getCustomerPayment(int id) {
	// TODO Auto-generated method stub
	  return (CustomerPaymentBean) sessionFactory.getCurrentSession().get(CustomerPaymentBean.class, id);

}

@Override
public void deleteCustomerPayment(CustomerPaymentBean customerPaymentBean) {
	// TODO Auto-generated method stub
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM customer_orders_products WHERE order_id = "+customerPaymentBean.getCustomerPaymentId()).executeUpdate();

	
}
}
