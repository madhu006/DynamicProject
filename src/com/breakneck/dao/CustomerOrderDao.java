



package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerOrderBean;


public interface CustomerOrderDao {
 
 public void addCustomerOrder(CustomerOrderBean customer);

 public List<CustomerOrderBean> listCustomerOrders();
 
 public CustomerOrderBean getCustomerOrder(int id);
 
 public void deleteCustomerOrder(CustomerOrderBean customerOrder);
 
 public List<CustomerOrderBean> getCustomerListByName(String search);

}
