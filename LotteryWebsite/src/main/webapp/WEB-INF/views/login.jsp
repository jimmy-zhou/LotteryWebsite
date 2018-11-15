<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>Login here:</h2>
	<sf:form action="login" method="POST" modelAttribute="loginPlayer">
		Username: <sf:input path="username" type="text" />
		Password: <sf:input path="password" type="password" />
		<input type="submit" value="login">
	</sf:form>
	<span style="color: red">${successMsg}</span>
	<a href="register">Go to register</a>
</body>
</html>