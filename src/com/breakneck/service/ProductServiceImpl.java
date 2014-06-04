

package com.breakneck.service;
/**
 * @author Madhulika Prasad
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.breakneck.dao.ProductDao;
import com.breakneck.model.Catagories;
import com.breakneck.model.Product;


@Component
@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

 @Autowired
  ProductDao productDao;
 
 @Override
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addProduct(Product product){
	 
	
	 
	 productDao.addProduct(product);
 }
 
 @Override
 public List<Product> listProducts(){
  return productDao.listProducts();
 }

 @Override
 public Product getProduct(int id){
 return productDao.getProduct(id);
 }
 
 @Override
 public void deleteProduct(Product product){
 productDao.deleteProduct(product);
 }
 
 public List<Product> getProductList(String search){
	return productDao.getProductListByName(search);
 }

}
