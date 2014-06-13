






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

import com.breakneck.bean.AddressBean;
import com.breakneck.bean.CustomerBean;


@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {

 @Autowired
  SessionFactory sessionFactory;
 

@Override
public void addAddress(AddressBean address) {
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
public List<AddressBean> listAddress() {
	// TODO Auto-generated method stub
	 Session session =  sessionFactory.getCurrentSession();
	  return session.createCriteria(AddressBean.class).list();
	 
}

@Override
public AddressBean getAddress(int id) {
	// TODO Auto-generated method stub
	  return (AddressBean) sessionFactory.getCurrentSession().get(AddressBean.class, id);

}

@Override
public void deleteAddress(AddressBean address) {
	// TODO Auto-generated method stub
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM addresses WHERE address_id = "+address.getAddressId()).executeUpdate();

}
}
