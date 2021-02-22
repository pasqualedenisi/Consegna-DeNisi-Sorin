<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

      <c:choose>   
         <c:when test = "${permissions == 1}">
			<p>Uee amministratò! </p>            
         </c:when>
         
         <c:when test = "${permissions == 2}">
            <p>Uee utè! </p>
         </c:when>
         
         <c:otherwise>
            Alla casa...
         </c:otherwise>
      </c:choose>
      
</body>
</html>