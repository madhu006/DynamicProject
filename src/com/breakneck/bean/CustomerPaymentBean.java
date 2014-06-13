package com.breakneck.bean;

public class CustomerPaymentBean {
	
	private int customerPaymentId;
	
	private String nameOnCard;
	
	private Integer customerId;
	
	private String cardType;
	
	private String cardNumber;
	
	private String dateFrom;
	
	private String dateTo;
	
	private String otherDetails;

	public int getCustomerPaymentId() {
		return customerPaymentId;
	}

	public void setCustomerPaymentId(int customerPaymentId) {
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

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

}
