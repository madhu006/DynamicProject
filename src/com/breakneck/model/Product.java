package com.breakneck.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="product")

public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "product_id")
	private Integer productId;
	 
	 @Column(name="parent_product_id")
	private Integer catagoryId;
	 
	 @Column(name="product_type_code")
	private String productCode;
	 
	 @Column(name="supplier_code")
	private String supplierCode;
	 
	 @Column(name="file_location")
		private String fileLocation;
		
	 @Column(name="product_price")
	private Integer price;
	 
	 @Column(name="product_details")
	private String productDetails;
	 /*
	 @Lob
	 @Column(name="product_image", nullable = false,
			 columnDefinition = "largeblol")
	private byte[] productImage;
	*/
	 
	 @Column(name="product_name")
	private String productName;
	 
	 @Column(name="product_quantity")
	private Integer productQuantity;
	 
	 @Column(name="product_weight")
	private Integer productWeight;
	
	
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	/*
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	*/
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Integer getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(Integer productWeight) {
		this.productWeight = productWeight;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
