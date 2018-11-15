<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make your bet</title>
</head>
<body>
	<h1>Bet</h1>
	<sf:form action="login" method="POST" modelAttribute="myBet">
		<input type="submit" value="login">
	</sf:form>
</body>
</html>