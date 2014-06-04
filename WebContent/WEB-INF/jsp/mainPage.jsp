<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="POST" action="/DynamicProject/template.html" >
 
<div id="mainContent" class="mainContent search_index" >


<table width="100%" cellspacing="10" cellpadding="10">

            <tr>
                <td class="featured_box"><span>
   
<span class="featured_item" >
		
	<c:forEach var="product" items="${productBean}">
	
	 <img style="padding: 5px;cursor: pointer;" src= "${product.fileLocation}"  alt="24LM Organic Sona Masuri Brown Rice" />
		<br />
		
     <option>${product.name}</option>
        <option>${product.price}</option>
              
    </c:forEach>	
</span>

</span>

</td>
</tr>
</table>

</div>
</form>
