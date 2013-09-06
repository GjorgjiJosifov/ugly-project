<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
</head>
<body>	
	<h1>List User Signup </h1>	
	
		
	<table>
	    <tr>
	    	<th>Username</th>
	    	<th>Sex</th>	    	
	    </tr>
	    <c:forEach items="${model.domainEntities}" var="entity">	    	    
			  <tr>
			    <c:out value="${entity.username}" />		    
			  <tr>
			  <tr>
			    <c:out value="${entity.sex}" />
			  </tr>		 
		 </c:forEach>
	</table>
	

</body>
</html>