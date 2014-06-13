

package com.breakneck.model;
/**
 * @author Madhulika Prasad
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer_address")
public class CustomerAddress implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @Column(name = "date_from")
 private Integer dateFrom;
 
 @Column(name="customer_id")
 private Integer customerId;
 
 @Column(name="address_id")
 private Integer addressId;
 
 @Column(name="address_type_code")
 private String addressTypeCode;
 
 
 @Column(name="date_to")
 private String dateTo;


public Integer getDateFrom() {
	return dateFrom;
}


public void setDateFrom(Integer dateFrom) {
	this.dateFrom = dateFrom;
}


public Integer getCustomerId() {
	return customerId;
}


public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}


public Integer getAddressId() {
	return addressId;
}


public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}


public String getAddressTypeCode() {
	return addressTypeCode;
}


public void setAddressTypeCode(String addressTypeCode) {
	this.addressTypeCode = addressTypeCode;
}


public String getDateTo() {
	return dateTo;
}


public void setDateTo(String dateTo) {
	this.dateTo = dateTo;
}
 
 

 

}
