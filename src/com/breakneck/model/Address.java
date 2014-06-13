

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
@Table(name="addresses")
public class Address implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "address_id")
 private Integer addressId;
 
 @Column(name="line_1")
 private String lineOne;
 
 @Column(name="line_2")
 private String lineTwo;
 
 @Column(name="line_3")
 private String lineThree;
 
 
 @Column(name="city")
 private String city;
 
 @Column(name="zip_postcode")
 private String zip;
 
 @Column(name="state_province_county")
 private String state;
 
 @Column(name="country")
 private String country;
 
 @Column(name="other_address_details")
 private String otherAddressDetails;

public Integer getAddressId() {
	return addressId;
}

public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}

public String getLineOne() {
	return lineOne;
}

public void setLineOne(String lineOne) {
	this.lineOne = lineOne;
}

public String getLineTwo() {
	return lineTwo;
}

public void setLineTwo(String lineTwo) {
	this.lineTwo = lineTwo;
}

public String getLineThree() {
	return lineThree;
}

public void setLineThree(String lineThree) {
	this.lineThree = lineThree;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getOtherAddressDetails() {
	return otherAddressDetails;
}

public void setOtherAddressDetails(String otherAddressDetails) {
	this.otherAddressDetails = otherAddressDetails;
}
 

}
