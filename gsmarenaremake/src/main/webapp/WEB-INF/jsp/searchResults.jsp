<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="/js/smartphones.js"></script>
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