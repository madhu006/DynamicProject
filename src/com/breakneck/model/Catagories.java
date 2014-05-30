package com.breakneck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Madhulika
 *
 */

@Entity
@Table(name="product_categories")
public class Catagories {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "CATEGORY_ID")
	int category_Id;
	
	 @Column(name = "CATEGORY_NAME")
	String category_Name;
	
	 @Column(name = "OTHER_CATEGORY_DETAILS")
	String other_Catogory_Details;
	
	 @Column(name = "DEPT_ID_fk")
	int dept_Id;

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public String getOther_Catogory_Details() {
		return other_Catogory_Details;
	}

	public void setOther_Catogory_Details(String other_Catogory_Details) {
		this.other_Catogory_Details = other_Catogory_Details;
	}

	public int getDept_Id() {
		return dept_Id;
	}

	public void setDept_Id(int dept_Id) {
		this.dept_Id = dept_Id;
	}
}
