<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<style type="text/css">
			.btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
			.icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}
		</style>
		<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<h1 align="center"><font color="blue">Hi! <%=session.getAttribute("userid")%>, Welcome To Order Processing System</font></h1><br>

		<h1 align="center"><font color="orange">Main Menu</font></h1>
		
		
		<div align="center" class="container">
			<a class="btn icon-btn btn-primary" href="http://localhost:8080/OrderProcessingSystemV5/cust/cmenu"><span class="glyphicon btn-glyphicon glyphicon-save img-circle text-muted"></span>Customers</a>
			<a class="btn icon-btn btn-success" href=""><span class="glyphicon btn-glyphicon glyphicon-remove-circle img-circle text-muted"></span>Products</a>
			<a class="btn icon-btn btn-primary" href=""><span class="glyphicon btn-glyphicon glyphicon-thumbs-up img-circle text-primary"></span>Orders</a>
			<a class="btn icon-btn btn-success" href=""><span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>Logout</a>					
		</div>		

</body>
</html>