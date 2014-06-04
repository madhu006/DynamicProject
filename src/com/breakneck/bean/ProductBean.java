package com.breakneck.bean;

import java.util.Arrays;

public class ProductBean {
	Integer productId;
	
	Integer catagoryId;
	
	String code;
	
	String supplierCode;
	
	Integer price;
	
	String productDetail;
	
//	byte[] image;
	
	String name;
	
	Integer quantity;
	
	Integer weight;
	
	String fileLocation;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
/*
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catagoryId;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result
				+ ((productDetail == null) ? 0 : productDetail.hashCode());
		result = prime * result + productId;
		result = prime * result + quantity;
		result = prime * result
				+ ((supplierCode == null) ? 0 : supplierCode.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBean other = (ProductBean) obj;
		if (catagoryId != other.catagoryId)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
	
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (productDetail == null) {
			if (other.productDetail != null)
				return false;
		} else if (!productDetail.equals(other.productDetail))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (supplierCode == null) {
			if (other.supplierCode != null)
				return false;
		} else if (!supplierCode.equals(other.supplierCode))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", catagoryId="
				+ catagoryId + ", code=" + code + ", supplierCode="
				+ supplierCode + ", price=" + price + ", productDetail="
				+ productDetail 
				+ ", name=" + name + ", quantity=" + quantity + ", weight="
				+ weight + "]";
	}

}
