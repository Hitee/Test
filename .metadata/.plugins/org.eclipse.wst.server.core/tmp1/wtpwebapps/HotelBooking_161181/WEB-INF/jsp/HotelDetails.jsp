<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Details</title>
<style>
table {
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}
</style>
</head>
<body>
	<div align="center">
		<table border=1>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Rating</th>
				<th>Rate</th>
				<th>Available Rooms</th>
			</tr>
			<c:forEach items="${hotellist}" var="list">
				<tr>
					<td>${list.id}</td>
					<td><a href="booking.do">${list.name}</a></td>
					<td>${list.rating}</td>
					<td>${list.rate}</td>
					<td>${list.availablerooms}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<h3>Click a Hotel name to start Booking</h3>
	</div>
</body>
</html>