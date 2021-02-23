<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script src="/js/users.js"></script>
<title>Utenti iscritti</title>
</head>
<body>


<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Type</th>
        <th>Select</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="user" items="${usersListPassed }">
    	<tr>
		  <td>${user.name }</td>
		  <td>${user.surname }</td>
		  <td>${user.email }</td>
		  <td>${user.type }</td>
		  <td><input name="bancheck" type="checkbox" id=${user.id }></td>
		</tr>
		</c:forEach>
      <tr>
    </tbody>
  </table>
</div>

<button type="button" class="btn btn-danger" id="banButton">Ban</button>




<!-- 
<c:forEach var="user" items="${usersListPassed }">
  <p>${user.name }</p>
  <p>${user.surname }</p>
  <p>${user.email }</p>
  <p>${user.type }</p>
</c:forEach>
 -->

</body>
</html>