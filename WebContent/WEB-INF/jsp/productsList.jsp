<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Products</title>
</head>
<body>
<h1>List Product</h1>
<h3><a href="addProduct.html">Add More Product</a></h3>

<c:if test="${!empty products}">
 <table align="left" border="1">
  <tr>
   <th>Product ID</th>
    <th>Catagory ID</th> 
   <th>Product Name</th>
   <th>Product Code</th>
   <th>Supplier Code</th>
   <th>Product Price</th>
   <th>Product Detail</th>
   <th>File Location</th>
   <th>Product Quantity</th>
   <th>Product Weight</th>
   
  </tr>

  <c:forEach items="${products}" var="product">
   <tr>
    <td><c:out value="${product.productId}"/></td>
    <td><c:out value="${product.catagoryId}"/></td>
    <td><c:out value="${product.name}"/></td>
    <td><c:out value="${product.code}"/></td>
    <td><c:out value="${product.supplierCode}"/></td>
     <td><c:out value="${product.price}"/></td>
    <td><c:out value="${product.productDetail}"/></td>
    <td><c:out value="${product.fileLocation}"/></td>
    <td><c:out value="${product.quantity}"/></td>
    <td><c:out value="${product.weight}"/></td>
  
     </tr>
  </c:forEach>
   </table>
</c:if>
</body>
</html>
