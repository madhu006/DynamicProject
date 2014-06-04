<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Spring MVC Form Handling</title>
  
  <script>
function myFunction()
{
var x = document.getElementById("myFile");
x.disabled = true;
}
</script>
 </head>
 <body>
  <h2>Add Product Data</h2>
  <form:form method="POST" action="/DynamicProject/saveProduct.html">
      <table>
       <tr>
           <td><form:label path="productId">Product ID:</form:label></td>
           <td><form:input path="productId" value="${product.productId}"  readonly="true" /></td>
       </tr>
       <tr>
           <td><form:label path="name">Product Name:</form:label></td>
           <td><form:input path="name" value="${product.name}"/></td>
       </tr>
       <tr>
           <td><form:label path="code">Product Code:</form:label></td>
           <td><form:input path="code" value="${product.code}"/></td>
       </tr>
       <tr>
           <td><form:label path="price"> Price:</form:label></td>
           <td><form:input path="price" value="${product.price}"/></td>
       </tr>
       
       <tr>
           <td><form:label path="catagoryId">Catagory Id:</form:label></td>
                    <td><form:input path="catagoryId" value="${product.catagoryId}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="supplierCode">Supplier Code:</form:label></td>
                    <td><form:input path="supplierCode" value="${product.supplierCode}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="fileLocation">Product Image:</form:label></td>   			
                    <td><form:input path = "fileLocation" type="file" id = "myFile"/></td>
       </tr>
       
        <tr>
           <td><form:label path="quantity">Quantity:</form:label></td>
                    <td><form:input path="quantity" value="${product.quantity}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="weight">Weight:</form:label></td>
                    <td><form:input path="weight" value="${product.weight}"/></td>
       </tr>
       
        <tr>
           <td><form:label path="productDetail">Product Details:</form:label></td>
                    <td><form:input path="productDetail" value="${product.productDetail}"/></td>
       </tr>
          <tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
   </table> 
  </form:form>
  
  <c:if test="${!empty products}">
  <h2>List Products</h2>
 <table align="left" border="1">
  <tr>
   <th>Product ID</th>
    <th>Catagory ID</th> 
   <th>Product Name</th>
   <th>Product Code</th>
   <th>Supplier Code</th>
   <th>Product Price</th>
   <th>Product Detail</th>
   <th>Product Image</th>
   <th>Product Quantity</th>
   <th>Product Weight</th>
   
   
           <th>Actions on Row</th>
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
  
    <td align="center"><a href="editProduct.html?productId=${product.productId}"> Edit</a> | <a href="deleteProduct.html?productId=${product.productId}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
 </body>
</html>

