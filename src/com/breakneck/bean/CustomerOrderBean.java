package com.breakneck.bean;

public class CustomerOrderBean {
	
	private int orderId;
	
	private Integer customerId;
	
	private Integer paymentId;
	
	private String orderStatusCode;
	
	private String dateOrderPlaced;
	
	private String dateOrderPaid;
	
	private Double totalCost;
	
	private String otherOrderDetails;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
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

	public void setPaymentMode(Integer paymentId) {
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

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getOtherOrderDetails() {
		return otherOrderDetails;
	}

	public void setOtherOrderDetails(String otherOrderDetails) {
		this.otherOrderDetails = otherOrderDetails;
	}
	
	
	
	

}
