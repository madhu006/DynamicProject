package com.breakneck.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.breakneck.dao.DepartmentDaoImpl;
import com.breakneck.dao.EmployeeDaoImpl;
import com.breakneck.dao.ProductDaoImpl;
import com.breakneck.model.Employee;
import com.breakneck.model.Product;

@RunWith( SpringJUnit4ClassRunner.class )
@org.springframework.context.annotation.Configuration
@ContextConfiguration(locations="classpath:resources/applicationContext.xml")

public class ProductDaoImplTest {
	 @Autowired
	 private SessionFactory sessionFactory;
	
	 private Session session = null;
	 @Autowired
	 ProductDaoImpl productDaoImpl;
	
	
	
@Test
public void testListProduct() {
	  session = sessionFactory.openSession();
	  session.beginTransaction();
	
	  ProductDaoImpl productDaoImpl = new ProductDaoImpl();		
	 List<Product> productList = productDaoImpl.listProducts();
	 session.close();
		
	 assertNotNull(productList);
	 }

@Test
public void testGetProduct() {
	  String str = "RASNA";
	  ProductDaoImpl productDaoImpl = new ProductDaoImpl();	
	  Product product = productDaoImpl.getProduct(1);
	  assertEquals(product.getProductName(),str);
		}

}
