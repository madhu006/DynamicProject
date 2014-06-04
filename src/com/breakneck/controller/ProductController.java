



package com.breakneck.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.breakneck.bean.ProductBean;
import com.breakneck.model.Product;
import com.breakneck.service.ProductService;

/**
 * 
 * @author Madhulika Prasad
 *
 */



@Controller
public class ProductController {
 
 @Autowired
  ProductService productService;
 
@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
public ModelAndView saveProduct(@ModelAttribute("command")ProductBean productBean, 
   BindingResult result) {
//	String fileName = productBean.getFileLocation();
	 
	 //File file = new File("images\\extjsfirstlook.jpg"); //windows
	/*
    File file = new File(fileName);
    byte[] bFile = new byte[(int) file.length()];

    try {
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bFile);
        fileInputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    productBean.setImage(bFile);
    */
  Product product = prepareModel(productBean);
  productService.addProduct(product);
  return new ModelAndView("redirect:/addProduct.html");
 }

 @RequestMapping(value="/products", method = RequestMethod.GET)
 public ModelAndView listProducts() {
  Map<String, Object> model = new HashMap<String ,Object>();
  model.put("products",  prepareListofBean(productService.listProducts()));
  return new ModelAndView("productsList", model);
 }

 @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
 public ModelAndView addProduct(@ModelAttribute("command")ProductBean productBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("products",  prepareListofBean(productService.listProducts()));
  return new ModelAndView("addProduct", model);
 }
 /*
@RequestMapping(value = "/", method = RequestMethod.GET)
public ModelAndView welcome() {
  return new ModelAndView("index");
 }
*/
@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
public ModelAndView editProduct(@ModelAttribute("command")ProductBean productBean,
   BindingResult result) {
	productService.deleteProduct(prepareModel(productBean));
  Map<String,Object> model = new HashMap<String, Object>();
  model.put("product", null);
  model.put("products",  prepareListofBean(productService.listProducts()));
  return new ModelAndView("addProduct", model);
 }
 
@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
public ModelAndView deleteProduct(@ModelAttribute("command")ProductBean productBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("product", prepareProductBean(productService.getProduct(productBean.getProductId())));
  model.put("products",  prepareListofBean(productService.listProducts()));
  return new ModelAndView("addProduct", model);
 }
 
 private Product prepareModel(ProductBean productBean){
	 Product product = new Product();
	 product.setProductId(productBean.getProductId());
	 product.setCatagoryId(productBean.getCatagoryId());
	 product.setProductCode(productBean.getCode());
	 product.setPrice(productBean.getPrice());
	 product.setProductDetails(productBean.getProductDetail());
	 product.setFileLocation(productBean.getFileLocation());
	 product.setProductName(productBean.getName());
	 product.setProductQuantity(productBean.getQuantity());
	 product.setProductWeight(productBean.getWeight());
	 product.setSupplierCode(productBean.getSupplierCode());
	 productBean.setProductId(null);
	  
  return product;
 }
 
 private List<ProductBean> prepareListofBean(List<Product> products){
  List<ProductBean> beans = null;
  if(products != null && !products.isEmpty()){
   beans = new ArrayList<ProductBean>();
   ProductBean bean = null;
   for(Product product : products){
    bean = new ProductBean();
    bean.setCatagoryId(product.getCatagoryId());
    bean.setProductId(product.getProductId());
    bean.setCode(product.getProductCode());
    bean.setPrice(product.getPrice());
    bean.setProductDetail(product.getProductDetails());
    bean.setFileLocation(product.getFileLocation());
    bean.setName(product.getProductName());
    bean.setQuantity(product.getProductQuantity());
    bean.setWeight(product.getProductWeight());
    bean.setSupplierCode(product.getSupplierCode());
	 beans.add(bean);
   }
  }
  return beans;
 }
 
 private ProductBean prepareProductBean(Product product){
  ProductBean bean = new ProductBean();
  bean.setCatagoryId(product.getCatagoryId());
  bean.setProductId(product.getProductId());
  bean.setCode(product.getProductCode());
  bean.setPrice(product.getPrice());
  bean.setProductDetail(product.getProductDetails());
  bean.setFileLocation(product.getFileLocation());
  bean.setName(product.getProductName());
  bean.setQuantity(product.getProductQuantity());
  bean.setWeight(product.getProductWeight());
  bean.setSupplierCode(product.getSupplierCode());
 return bean;
 }
}
