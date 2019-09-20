<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style1.css" />" />

</head>
<body>
	 
    <div class="container">
        <div class="card card-container">            
            <img id="profile-img" class="profile-img-card" src="<c:url value="/resources/images/bear.jpg" />" />
            <!-- <img id="profile-img" class="profile-img-card" src="/OrderProcessingSystemV5/resources/images/bear.jpg" /> -->
            <p id="profile-name" class="profile-name-card"></p>
            <form:form class="form-signin" modelAttribute="user" action="http://localhost:8080/OrderProcessingSystemV5/logc/verify"  method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <form:input path="userId" id="inputEmail" class="form-control"/><form:errors path="userId" cssClass="error"/>
                <form:password path="password" id="inputPassword" class="form-control"/><form:errors path="password" cssClass="error"/>
                <input type="submit" class="btn btn-lg btn-primary btn-block btn-signin" value="                                        Login                                         " size="100">
            </form:form>
          </div>
    </div>
</body>
</html>