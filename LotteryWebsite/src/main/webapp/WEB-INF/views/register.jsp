<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h2>Register here:</h2>
	<sf:form action="register" method="post"
		modelAttribute="registerPlayer">
		<sf:input type="text" path="username"
			placeholder="enter username here" />
		<sf:input type="password" path="password"
			placeholder="enter password here" />
		<h4>Make sure that your username is at least 3 characters and
			password is at least 6 characters</h4>
		<sf:input type="text" path="firstName"
			placeholder="enter your first name" />
		<sf:input type="text" path="lastName"
			placeholder="enter your last name" />
		<sf:select path="stateName">
			<option value="NY">NY</option>
			<option value="CA">CA</option>
			<option value="NJ">NJ</option>
			<option value="WA">WA</option>
			<option value="SC">SC</option>
			<option value="PA">PA</option>
			<option value="FL">FL</option>
			<option value="VA">VA</option>
			<option value="OR">OR</option>
			<option value="AZ">AZ</option>
		</sf:select>
		<h4></h4>
		<sf:input type="text" path="creditCard"
			placeholder="enter your credit card number" />
		<h4></h4>
		<input type="submit" value="Register!">
		<a href="login">Go to login</a>
	</sf:form>
	<span style="color: red">${errorMsg}</span>
</body>
</html>