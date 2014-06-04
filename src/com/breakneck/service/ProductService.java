


package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.model.Product;


public interface ProductService {
 
 public void addProduct(Product product);

 public List<Product> listProducts();
 
 public Product getProduct(int empid);
 
 public void deleteProduct(Product product);
 
 public List<Product> getProductList(String search);

}
