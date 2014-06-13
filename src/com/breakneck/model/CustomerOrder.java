




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
@Table(name="customer_orders")
public class CustomerOrder implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "order_id")
 private Integer orderId;
 
 @Column(name="customer_id")
 private Integer customerId;
 
 @Column(name="customer_payment_method")
 private Integer paymentId;
 
 @Column(name="order_status_code")
 private String orderStatusCode;
 
 
 @Column(name="date_order_placed")
 private String dateOrderPlaced;
 
 @Column(name="date_order_paid")
 private String dateOrderPaid;
 
 @Column(name="der_total_order_price")
 private Double totalOrderPrice;
 
 @Column(name="other_order_details")
 private String otherOrderDetails;

public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}

public Integer getCustomerId() {
	return customerId;
}

public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}


public Integer getPaymentId() {
	return paymentId;
}

public void setPaymentId(Integer paymentId) {
	this.paymentId = paymentId;
}

public String getOrderStatusCode() {
	return orderStatusCode;
}

public void setOrderStatusCode(String orderStatusCode) {
	this.orderStatusCode = orderStatusCode;
}

public String getDateOrderPlaced() {
	return dateOrderPlaced;
}

public void setDateOrderPlaced(String dateOrderPlaced) {
	this.dateOrderPlaced = dateOrderPlaced;
}

public String getDateOrderPaid() {
	return dateOrderPaid;
}

public void setDateOrderPaid(String dateOrderPaid) {
	this.dateOrderPaid = dateOrderPaid;
}

public Double getTotalOrderPrice() {
	return totalOrderPrice;
}

public void setTotalOrderPrice(Double totalOrderPrice) {
	this.totalOrderPrice = totalOrderPrice;
}

public String getOtherOrderDetails() {
	return otherOrderDetails;
}

public void setOtherOrderDetails(String otherOrderDetails) {
	this.otherOrderDetails = otherOrderDetails;
}
 





}
