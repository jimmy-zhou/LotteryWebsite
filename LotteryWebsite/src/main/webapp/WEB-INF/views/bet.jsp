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
	<sf:form action="bet" method="POST" modelAttribute="myBet">
		pick your main numbers: <sf:input type="text" path="mainNumber" />
		Pick your powerball number: <sf:input type="text" path="powerballNumber" />
		<input type="submit" value="Bet!">
	</sf:form>
	<span style="color: red">This is week's winning number is:
		${main} ${powerball}</span>
	<h2></h2>
	<span style="color: red">The accumulated prize count is ${prize}
		Good luck!</span>
	<h2></h2>
	<span style="color: blue">Your pick is ${pick} Jackpot!</span>
</body>
</html>