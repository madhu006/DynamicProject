<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" import="com.breakneck.controller.DepartmentController"%> 

<%@ page language="java" import="com.breakneck.bean.SearchBean"%> 

<form method="POST" action="/DynamicProject/template.html" >
  
<div id="header">
    <table>
    <tr>
        <td align="left" width="30%">
            <span style="border: none;">
    <a  style="text-decoration: none;"><img src="/DynamicProject/image/logo.png" alt ="breakneck.in" /></a>
      </span>
      </td>
      <td>    
       </td>
        <td>
    <table id="mainSearchInputWrapper" cellpadding="0" cellspacing="0">
        <tr>
            <td class="combobox_button_wrapper"><div id="combobox_button" tabIndex=-1></div></td>
            <td class="td_combobox_input">
    <span id="combobox_categories_wrapper">
     
  
               <select>
    <c:forEach var="catagory" items="${catagories}">
     <option>${catagory.catagoryName}</option>
    </c:forEach>
</select>   
</span>
 </td>
 		
 		 
 		  <td><input type="text"  name="search" size="30" onclick="searchPrductByName"></td>
            
        </tr>

       </table>       
    </table>     
      </div>     
     
    </form> 

