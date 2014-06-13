package com.breakneck.bean;

public class CustomerBean {
	
	private int customerId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String phone;
	
	private String email;
	
	private String otherCustomerDetails;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
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

	public String getOtherCustomerDetails() {
		return otherCustomerDetails;
	}

	public void setOtherCustomerDetails(String otherCustomerDetails) {
		this.otherCustomerDetails = otherCustomerDetails;
	}

}
