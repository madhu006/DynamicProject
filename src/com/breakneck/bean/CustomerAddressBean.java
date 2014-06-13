package com.breakneck.bean;

public class CustomerAddressBean {

	private int customerId;
	
	private Integer addressId;
	
	private String Datefrom;
	
	private String addressTypeCode;
	
	private String DateTo;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getDatefrom() {
		return Datefrom;
	}

	public void setDatefrom(String datefrom) {
		Datefrom = datefrom;
	}

	public String getAddressTypeCode() {
		return addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public String getDateTo() {
		return DateTo;
	}

	public void setDateTo(String dateTo) {
		DateTo = dateTo;
	}
	
	
}
