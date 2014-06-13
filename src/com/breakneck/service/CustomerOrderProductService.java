



package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerOrderProductBean;



public interface CustomerOrderProductService {
 
 public void addCustomerOrderedProduct(CustomerOrderProductBean customerOrderProduct);

 public List<CustomerOrderProductBean> listCustomerOrderProduct();
 
 public CustomerOrderProductBean getCustomerOrderProduct(int id);
 
 public void deleteCustomerOrderProduct(CustomerOrderProductBean customerOrderProduct);
}
