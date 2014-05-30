<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <c:forEach var="dept" items="${departments}">
     <option>${dept}</option>
    </c:forEach>
</select>   
</span>
 </td>
            <td>
                <input name="mainSearchInput" type="text" id="mainSearchInput" size="35" class="empty_searchbox" placeholder="Search here... eg. soup" />
            </td>
        </tr>

       </table>       
    </table>     
      </div>     
      
     

