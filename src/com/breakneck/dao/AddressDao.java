



package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.AddressBean;


public interface AddressDao {
 
 public void addAddress(AddressBean address);

 public List<AddressBean> listAddress();
 
 public AddressBean getAddress(int id);
 
 public void deleteAddress(AddressBean address);
 
}
