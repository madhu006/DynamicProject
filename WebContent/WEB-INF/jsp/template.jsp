<%@include file="topBar.jsp" %>

<%@include file="header.jsp" %>

<%@include file="sideBarLeft.jsp" %>

<%@include file="sideBarRight.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>

<form method="POST" action="/DynamicProject/template.html" >
<div id="mainContent" class="mainContent search_index" >

<table width="100%" cellspacing="10" cellpadding="10" >

     <tr>
	 
                <td class="featured_box"><span>
                <span class="featured_item" >
	      
	<c:forEach var="product"  items="${productBean}">
	 		
	 <img style="padding: 5px;cursor: pointer;" src= "${product.fileLocation}"  />
	  <option >${product.productId}</option>   	
     <option >${product.name}</option>   
        <option>Rs</option>   
        <option >${product.price}</option>        
        
      
        <br>  
           <button id ="addItem"  data-value = "${product.productId}" data-value1 ="${product.name }" data-value2 = "${product.price }">Buy 1
           </button>
     
            <br>  
                  
    </c:forEach>	
      </span>
    </span>
    </td>
</tr> 
   
</table>
   
  <script>
	
$(document).on("click", "#addItem", function(){
	  alert ('button clicked');
	     alert($(this).attr('data-value'));
	     
	  var id = $(this).attr('data-value');
	  var itemName =$(this).attr('data-value1') ;
	  var itemQuantity = 1;
	  var itemPrice =  $(this).attr('data-value2');
	  alert (id);	 	
	  var request = $.ajax({
	    url: "http://localhost:8080/DynamicProject/addToCart",
	    type: "POST",
	    data: { productId : id, name: itemName, quantity:itemQuantity, price:itemPrice }
	  });	 
	  
	});
</script>
</div>
</form>
<%@include file="footer.jsp" %>