

package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.CustomerAddressBean;


public interface CustomerAddressDao {
 
 public void addCustomerAddress(CustomerAddressBean customerAddress);

 public List<CustomerAddressBean> listCustomerAddress();
 
 public CustomerAddressBean getCustomerAddress(int id);
 
 public void deleteCustomerAddress(CustomerAddressBean customerAddress);
 
}
