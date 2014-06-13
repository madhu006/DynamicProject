


package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerOrderBean;



public interface CustomerOrderService {
 
 public void addCustomerOrder(CustomerOrderBean customerOrder);

 public List<CustomerOrderBean> listCustomerOrder();
 
 public CustomerOrderBean getCustomerOrder(int id);
 
 public void deleteCustomerOrder(CustomerOrderBean customerOrder);
}
