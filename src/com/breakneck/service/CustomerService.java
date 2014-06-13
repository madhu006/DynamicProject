

package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerBean;



public interface CustomerService {
 
 public void addCustomer(CustomerBean customer);

 public List<CustomerBean> listCustomer();
 
 public CustomerBean getCustomer(int id);
 
 public void deleteCustomer(CustomerBean customer);
}
