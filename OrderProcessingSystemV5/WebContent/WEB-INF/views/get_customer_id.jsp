<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style1.css" rel="stylesheet">
</head>
<body>
	 <div class="container">
        <div class="card card-container"> 
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="getCustomer" method="get">
                <span id="reauth-email" class="reauth-email"></span>                
                <input type="text"  name="customerid" id="customerid" class="form-control" placeholder="Customer Id" required>
                
                <input type="submit" class="btn btn-lg btn-primary btn-block btn-signin" value="                                        Submit                                              " size="100">
            </form><!-- /form -->           
            
        </div><!-- /card-container -->
        		
    </div><!-- /container -->
    
</body>
</html>