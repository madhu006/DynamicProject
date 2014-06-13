


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
@Table(name="customers_payments_methods")
public class CustomerPayment implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "customers_payments_methods_id")
 private Integer customerPaymentId;
 
 @Column(name="customer_id")
 private Integer customerId;
 
 @Column(name="name_oncard")
 private String nameOnCard;
 
 @Column(name="payments_method")
 private String cardType;
 
 @Column(name="card_number")
 private String cardNumber;
 
 
 @Column(name="date_from")
 private String validityFrom;
 
 @Column(name="date_to")
 private String validityTo;
 
 @Column(name="other_details")
 private String otherDetails;

public Integer getCustomerPaymentId() {
	return customerPaymentId;
}

public void setCustomerPaymentId(Integer customerPaymentId) {
	this.customerPaymentId = customerPaymentId;
}

public Integer getCustomerId() {
	return customerId;
}

public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}

public String getCardType() {
	return cardType;
}

public void setCardType(String cardType) {
	this.cardType = cardType;
}

public String getCardNumber() {
	return cardNumber;
}

public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}

public String getValidityFrom() {
	return validityFrom;
}

public void setValidityFrom(String validityFrom) {
	this.validityFrom = validityFrom;
}

public String getValidityTo() {
	return validityTo;
}

public void setValidityTo(String validityTo) {
	this.validityTo = validityTo;
}

public String getOtherDetails() {
	return otherDetails;
}

public void setOtherDetails(String otherDetails) {
	this.otherDetails = otherDetails;
}
 


 

}
