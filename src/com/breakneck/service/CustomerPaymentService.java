



package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerPaymentBean;



public interface CustomerPaymentService {
 
 public void addPayment(CustomerPaymentBean payment);

 public List<CustomerPaymentBean> listPayment();
 
 public CustomerPaymentBean getPayment(int id);
 
 public void deletePayment(CustomerPaymentBean address);
}
