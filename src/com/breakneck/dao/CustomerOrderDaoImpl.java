



package com.breakneck.dao;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.breakneck.bean.CustomerBean;
import com.breakneck.bean.CustomerOrderBean;


@Repository("customerOrderDao")
public class CustomerOrderDaoImpl implements CustomerOrderDao {

 @Autowired
  SessionFactory sessionFactory;
 

@Override
public void addCustomerOrder(CustomerOrderBean customerOrder) {
	// TODO Auto-generated method stub
	 try {
 		 Session session =sessionFactory.openSession();
 		 
 		Transaction transaction = session.beginTransaction();
 		session.saveOrUpdate(customerOrder);
 	transaction.commit();
 	session.close();
 	 }
 	 catch(RuntimeException e){
 	//	 sessionFactory.getCurrentSession().getTransaction().commit();
 	 }	
}

@SuppressWarnings("unchecked")
@Override
public List<CustomerOrderBean> listCustomerOrders() {
	// TODO Auto-generated method stub
	 Session session =  sessionFactory.getCurrentSession();
	  return session.createCriteria(CustomerOrderBean.class).list();
	
}

@Override
public CustomerOrderBean getCustomerOrder(int id) {
	// TODO Auto-generated method stub
	  return (CustomerOrderBean) sessionFactory.getCurrentSession().get(CustomerOrderBean.class, id);
}

@Override
public void deleteCustomerOrder(CustomerOrderBean customerOrder) {
	// TODO Auto-generated method stub
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM customer_orders WHERE order_id = "+customerOrder.getCustomerId()).executeUpdate();

}

@Override
public List<CustomerOrderBean> getCustomerListByName(String search) {
	// TODO Auto-generated method stub
	return null;
}
}
