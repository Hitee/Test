<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
in home page

	<form:form action="store.abc" modelAttribute="flightObj" method="POST">
	
	name : <form:input path="flightName"/>
	type: <form:input path="classtype"/>
	<input type="submit" value="store"/>
	</form:form>
	



</body>
</html>