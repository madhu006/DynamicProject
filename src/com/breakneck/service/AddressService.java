

package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.bean.AddressBean;



public interface AddressService {
 
 public void addAddress(AddressBean address);

 public List<AddressBean> listAddress();
 
 public AddressBean getAddress(int id);
 
 public void deleteAddress(AddressBean address);
}
