


package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.breakneck.bean.CustomerBean;
import com.breakneck.dao.CustomerDao;

@Component
@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

 @Autowired
 CustomerDao customerDao;
 


@Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public void addCustomer(CustomerBean customer) {
	// TODO Auto-generated method stub
	customerDao.addCustomer(customer);

	
}

@Override
public List<CustomerBean> listCustomer() {
	// TODO Auto-generated method stub
	  return customerDao.listCustomers();
}

@Override
public CustomerBean getCustomer(int id) {
	// TODO Auto-generated method stub
	  return customerDao.getCustomer(id);
}

@Override
public void deleteCustomer(CustomerBean customer) {
	// TODO Auto-generated method stub
	customerDao.deleteCustomer(customer);
	
}

}
