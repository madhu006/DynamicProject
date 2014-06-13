


package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerOrderProductBean;


public interface CustomerOrderProductDao {
 
 public void addCustomerOrderProduct(CustomerOrderProductBean customerOrderProduct);

 public List<CustomerOrderProductBean> listCustomerOrderProduct();
 
 public CustomerOrderProductBean getCustomerOrderProduct(int id);
 
 public void deleteCustomer(CustomerOrderProductBean customerOrderProduct);
 

}
