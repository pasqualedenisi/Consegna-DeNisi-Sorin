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
  <link rel="stylesheet" href="css/smartphones.css" type="text/css">
<title>Smartphones</title>
</head>
<body>

<p>Elenco</p>

<div class="row">
	<c:forEach var="device" items="${smartphoneListPassed }">
		<div class="col-md-3">
		  <a href="">
			<div class="card"">
			  <img class="card-img-top" src="/images/${device.serialNumber }.jpg" alt="image">
			  <div class="card-body text-center">
			    <p class="card-text">${device.name }</p>
			  </div>
			</div>
		  </a>
		</div>
	</c:forEach>
</div>
<!-- 
<a href="">
	<div class="card" style="width:20rem;margin:20px 0 24px 0">
	  <img class="card-img-top" src="images/iphone.jpg" alt="image" style="width:100%">
	  <div class="card-body text-center">
	    <p class="card-text">I phone</p>
	  </div>
	</div>
</a>
 -->
 
<c:if test="${permissions == 1}">
 	<a href="newDevice">Aggiungi dispositivo</a>         
</c:if>
 
 
</body>
</html>
