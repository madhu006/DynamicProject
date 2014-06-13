



package com.breakneck.model;
/**
 * @author Madhulika Prasad
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customers")
public class Customer implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "customer_id")
 private Integer customerId;
 
 @Column(name="first_name")
 private String firstName;
 
 @Column(name="middle_name")
 private String middleName;
 
 @Column(name="last_name")
 private String lastName;
 
 
 @Column(name="customer_phone")
 private String phone;
 
 @Column(name="customer_email")
 private String email;
 
 @Column(name="other_customer_details")
 private String customerDetails;

public Integer getCustomerId() {
	return customerId;
}

public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCustomerDetails() {
	return customerDetails;
}

public void setCustomerDetails(String customerDetails) {
	this.customerDetails = customerDetails;
}
 


}
