


package com.breakneck.dao;
/**
 *  @author Madhulika Prasad
 */

import java.util.List;

import com.breakneck.model.Product;


public interface ProductDao {
 
 public void addProduct(Product product);

 public List<Product> listProducts();
 
 public Product getProduct(int id);
 
 public void deleteProduct(Product product);
 
 public List<Product> getProductListByName(String search);

}
