


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

import com.breakneck.bean.AddressBean;
import com.breakneck.bean.CustomerOrderBean;
import com.breakneck.dao.AddressDao;
import com.breakneck.dao.CustomerOrderDao;

@Component
@Service("customerOrderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerOrderServiceImpl implements CustomerOrderService {

 @Autowired
 CustomerOrderDao customerOrderDao;
 


@Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public void addCustomerOrder(CustomerOrderBean customerOrder) {
	// TODO Auto-generated method stub
	customerOrderDao.addCustomerOrder(customerOrder);

}

@Override
public List<CustomerOrderBean> listCustomerOrder() {
	// TODO Auto-generated method stub
	  return customerOrderDao.listCustomerOrders();
		}

@Override
public CustomerOrderBean getCustomerOrder(int id) {
	// TODO Auto-generated method stub
	  return customerOrderDao.getCustomerOrder(id);
}

@Override
public void deleteCustomerOrder(CustomerOrderBean customerOrder) {
	// TODO Auto-generated method stub
	customerOrderDao.deleteCustomerOrder(customerOrder);
	
}

}
