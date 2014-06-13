

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
import com.breakneck.bean.CustomerOrderProductBean;
import com.breakneck.dao.AddressDao;
import com.breakneck.dao.CustomerOrderProductDao;

@Component
@Service("customerOrderProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerOrderProductServiceImpl implements CustomerOrderProductService {

 @Autowired
 CustomerOrderProductDao customerOrderProductDao;
 

@Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public void addCustomerOrderedProduct(
		CustomerOrderProductBean customerOrderProduct) {
	customerOrderProductDao.addCustomerOrderProduct(customerOrderProduct);
	
	// TODO Auto-generated method stub
	
}

@Override
public List<CustomerOrderProductBean> listCustomerOrderProduct() {
	// TODO Auto-generated method stub
	  return customerOrderProductDao.listCustomerOrderProduct();
}

@Override
public CustomerOrderProductBean getCustomerOrderProduct(int id) {
	// TODO Auto-generated method stub
	  return customerOrderProductDao.getCustomerOrderProduct(id);
}

@Override
public void deleteCustomerOrderProduct(
		CustomerOrderProductBean customerOrderProduct) {
	customerOrderProductDao.deleteCustomer(customerOrderProduct);

}

}
