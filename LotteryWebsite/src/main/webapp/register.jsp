<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h2>Register here:</h2>
	<form action="register" method="post">
		<input type="text" name="username" placeholder="enter username here">
		<input type="password" name="password"
			placeholder="enter password here">
		<h4>Make sure that your username is at least 3 characters and
			password is at least 6 characters</h4>
		<input type="text" name="first_name"
			placeholder="enter your first name"> <input type="text"
			name="last_name" placeholder="enter your last name"> <select
			name="state_name">
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
		</select>
		<h4></h4>
		<input type="text" name="credit_card"
			placeholder="enter your credit card number">
		<h4></h4>
		<input type="submit" value="Register!"> <a href="login">Go
			to login</a>
	</form>
	<span style="color: red">${error_msg}</span>
</body>
</html>