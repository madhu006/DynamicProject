<%@ page language="java" import="java.util.*, com.breakneck.*"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 
<link
 href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/themes/base/jquery-ui.css"
 rel="stylesheet" type="text/css" />
<script
 src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
 type="text/javascript"></script>
<script
 src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/jquery-ui.min.js"
 type="text/javascript"></script>
<script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script>
 

</head>
<body>

<div id="sidebar1">
    <div class="shopbydep">
    Shop by
    <b>Departments</b>
</div>

<div class="sidebar1_body ui-state-default" id="menu_sidebar" style="padding-top: 10px;background-color: #fff; border-bottom:none;">
<span id="menu_arrow" class="ui-icon"></span>
<div id='submenu' class="closeOnEsc" style='display: none;'></div>
<div id="menu_cb" style="margin: 0px; padding-left: 10px;">
 
   
      
   
  
   
   <ul id="accordion">
       <c:forEach var="dept" items="${departmentToCatagories.keySet()}">
  
    <li><div>${dept.deptName}</div>
        <ul>
         <c:forEach var="catog" items="${departmentToCatagories.get(dept)}">
        
            <li><a href="#">${catog.catagoryName} </a></li>
              </c:forEach>  
           </ul>
            </li>
            </c:forEach>    
    
  </ul>
 
 
</div>
</div>
<script type="text/javascript">

$("#accordion > li > div").click(function(){
	 
    if(false == $(this).next().is(':visible')) {
        $('#accordion ul').slideUp();
    }
    $(this).next().slideToggle();
});
$('#accordion ul').hide();
</script>
</div>

</body>