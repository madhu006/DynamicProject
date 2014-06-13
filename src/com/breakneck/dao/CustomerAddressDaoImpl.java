


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

import com.breakneck.bean.AddressBean;
import com.breakneck.bean.CustomerAddressBean;


@Repository("customerAddressDao")
public class CustomerAddressDaoImpl implements CustomerAddressDao {

 @Autowired
  SessionFactory sessionFactory;
 

@Override
public void addCustomerAddress(CustomerAddressBean address) {
	// TODO Auto-generated method stub
	
	 try {
 		 Session session =sessionFactory.openSession();
 		 
 		Transaction transaction = session.beginTransaction();
 		session.saveOrUpdate(address);
 	transaction.commit();
 	session.close();
 	 }
 	 catch(RuntimeException e){
 	//	 sessionFactory.getCurrentSession().getTransaction().commit();
 	 }	
	
	
}

@SuppressWarnings("unchecked")
@Override
public List<CustomerAddressBean> listCustomerAddress() {
	// TODO Auto-generated method stub
	 Session session =  sessionFactory.getCurrentSession();
	  return session.createCriteria(AddressBean.class).list();
	
}

@Override
public CustomerAddressBean getCustomerAddress(int id) {
	// TODO Auto-generated method stub
	  return (CustomerAddressBean) sessionFactory.getCurrentSession().get(CustomerAddressBean.class, id);

}

@Override
public void deleteCustomerAddress(CustomerAddressBean address) {
	// TODO Auto-generated method stub
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM customer_address WHERE product_id = "+address.getAddressId()).executeUpdate();

}
}
