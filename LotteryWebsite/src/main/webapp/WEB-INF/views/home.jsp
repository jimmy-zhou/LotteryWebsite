<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>You have logged in! ${activeUser}</h1>
	<h2>This is your lucky powerball number today: ${luckyNumber}</h2>
	 <a href="bet">Make new bet</a>
</body>
</html>