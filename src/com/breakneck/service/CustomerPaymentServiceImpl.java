


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
import com.breakneck.bean.CustomerPaymentBean;
import com.breakneck.dao.AddressDao;
import com.breakneck.dao.CustomerPaymentDao;

@Component
@Service("customerPaymentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerPaymentServiceImpl implements CustomerPaymentService {

 @Autowired
 CustomerPaymentDao paymentDao;
 




@Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

public void addPayment(CustomerPaymentBean payment) {
	// TODO Auto-generated method stub
	paymentDao.addCustomerPayment(payment);
	
}

@Override
public List<CustomerPaymentBean> listPayment() {
	// TODO Auto-generated method stub
	  return paymentDao.listCustomerPayment();
		}

@Override
public CustomerPaymentBean getPayment(int id) {
	// TODO Auto-generated method stub
	  return paymentDao.getCustomerPayment(id);
}

@Override
public void deletePayment(CustomerPaymentBean payment) {
	// TODO Auto-generated method stub
	paymentDao.deleteCustomerPayment(payment);

}

}
