<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utenti iscritti</title>
</head>
<body>

<c:forEach var="user" items="${usersListPassed }">
  <p>${user.name }</p>
  <p>${user.surname }</p>
  <p>${user.email }</p>
  <p>${user.type }</p>
</c:forEach>

</body>
</html>