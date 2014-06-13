

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
import com.breakneck.dao.AddressDao;

@Component
@Service("addressService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AddressServiceImpl implements AddressService {

 @Autowired
  AddressDao addressDao;
 

@Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public void addAddress(AddressBean address) {
	// TODO Auto-generated method stub
	addressDao.addAddress(address);
	  
}

@Override
public List<AddressBean> listAddress() {
	// TODO Auto-generated method stub
	  return addressDao.listAddress();
	  }

@Override
public AddressBean getAddress(int id) {
	// TODO Auto-generated method stub
	  return addressDao.getAddress(id);
}

@Override
public void deleteAddress(AddressBean address) {
	// TODO Auto-generated method stub
	addressDao.deleteAddress(address);
	 
}

}
