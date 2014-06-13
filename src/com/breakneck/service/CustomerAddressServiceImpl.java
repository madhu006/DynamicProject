


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
import com.breakneck.bean.CustomerAddressBean;
import com.breakneck.dao.AddressDao;
import com.breakneck.dao.CustomerAddressDao;

@Component
@Service("customerAddressService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerAddressServiceImpl implements CustomerAddressService {

 @Autowired
  CustomerAddressDao customerAddressDao;
 



@Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public void addCustomerAddress(CustomerAddressBean address) {
	// TODO Auto-generated method stub
	customerAddressDao.addCustomerAddress(address);

	
}

@Override
public List<CustomerAddressBean> listCustomerAddress() {
	// TODO Auto-generated method stub
	  return customerAddressDao.listCustomerAddress();
}

@Override
public CustomerAddressBean getCustomerAddress(int id) {
	// TODO Auto-generated method stub
	  return customerAddressDao.getCustomerAddress(id);
}

@Override
public void deleteCustomerAddress(CustomerAddressBean address) {
	// TODO Auto-generated method stub
	customerAddressDao.deleteCustomerAddress(address);

}

}
