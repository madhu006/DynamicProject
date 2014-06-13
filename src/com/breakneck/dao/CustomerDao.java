

package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerBean;


public interface CustomerDao {
 
 public void addCustomer(CustomerBean customer);

 public List<CustomerBean> listCustomers();
 
 public CustomerBean getCustomer(int id);
 
 public void deleteCustomer(CustomerBean customer);
 
 public List<CustomerBean> getCustomerListByName(String search);

}
