



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


@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

 @Autowired
  SessionFactory sessionFactory;
 

@Override
public void addCustomer(CustomerBean customer) {
	// TODO Auto-generated method stub
	 try {
 		 Session session =sessionFactory.openSession();
 		 
 		Transaction transaction = session.beginTransaction();
 		session.saveOrUpdate(customer);
 	transaction.commit();
 	session.close();
 	 }
 	 catch(RuntimeException e){
 	//	 sessionFactory.getCurrentSession().getTransaction().commit();
 	 }	
	
}

@SuppressWarnings("unchecked")
@Override
public List<CustomerBean> listCustomers() {
	// TODO Auto-generated method stub
	 Session session =  sessionFactory.getCurrentSession();
	  return session.createCriteria(CustomerBean.class).list();
	 
}

@Override
public CustomerBean getCustomer(int id) {
	// TODO Auto-generated method stub
	  return (CustomerBean) sessionFactory.getCurrentSession().get(CustomerBean.class, id);

}

@Override
public void deleteCustomer(CustomerBean customer) {
	// TODO Auto-generated method stub
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM customers WHERE product_id = "+customer.getCustomerId()).executeUpdate();

	
}

@SuppressWarnings("unchecked")
@Override
public List<CustomerBean> getCustomerListByName(String search) {
	 Session session = sessionFactory.getCurrentSession();	 
		List<CustomerBean> customerList = session.createCriteria(CustomerBean.class).add(Restrictions.ilike("productName",search , MatchMode.ANYWHERE)).list();
//		 session.close();
		  return customerList;

	
}
}
