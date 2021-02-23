<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
</head>
<body>

<div class="row">
	<c:forEach var="device" items="${resultsListPassed }">
		<div class="col-md-3">
		  <a href="">
			<div class="card"">
			  <!--  <img class="card-img-top" src="/images/${device.serialNumber }.jpg" alt="image">-->
			  <div class="card-body text-center">
			    <p class="card-text">${device.name }</p>
			  </div>
			</div>
		  </a>
		</div>
	</c:forEach>
</div>

</body>
</html>