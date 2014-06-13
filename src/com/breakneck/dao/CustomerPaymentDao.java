


package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerPaymentBean;


public interface CustomerPaymentDao {
 
 public void addCustomerPayment(CustomerPaymentBean customerPaymentBean);

 public List<CustomerPaymentBean> listCustomerPayment();
 
 public CustomerPaymentBean getCustomerPayment(int id);
 
 public void deleteCustomerPayment(CustomerPaymentBean customerPaymentBean);
 

}
