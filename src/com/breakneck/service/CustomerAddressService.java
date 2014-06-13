




package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerAddressBean;



public interface CustomerAddressService {
 
 public void addCustomerAddress(CustomerAddressBean address);

 public List<CustomerAddressBean> listCustomerAddress();
 
 public CustomerAddressBean getCustomerAddress(int id);
 
 public void deleteCustomerAddress(CustomerAddressBean address);
}
