


package com.breakneck.model;
/**
 * @author Madhulika Prasad
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="customer_orders_products")
public class CustomerOrderProduct implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Column(name = "order_id")
 private Integer orderId;
 
 @Column(name="product_id")
 private Integer productId;
 
 @Column(name="quantity")
 private String quantity;
 
 @Column(name="comments")
 private String comments;

public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}

public Integer getProductId() {
	return productId;
}

public void setProductId(Integer productId) {
	this.productId = productId;
}

public String getQuantity() {
	return quantity;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}
 
 
 


 

}
