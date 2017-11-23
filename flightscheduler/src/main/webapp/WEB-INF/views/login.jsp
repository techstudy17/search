<!-- JSP tags links -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>

<head>
<!-- CSS Bootstrap links -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<!-- Local JS and CSS used in this page -->
<script src="/flightscheduler/resources/js/hotelbooking.js"></script>
<link rel="stylesheet"
	href="/flightscheduler/resources/css/hotelbooking.css">
<!-- Meta Information -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Title comes in browser tab -->
<title>Hotel Booking</title>
</head>
<body style="background-image: url('/flightscheduler/resources/hotel.jpg');">

	<!-- Below code will appear on top for Home and Register -->
	<div class="topnav">
		<a class="active" href="registeruser">Register</a>
	</div>
		

	<div class="container">
		<div class="jumbotron" id="loginjumbo">

			<!-- modelAttribute holds object sent from controller (mav.addObject("login", new Login());) 
			and action will form URL and access controller -->
			<%-- <form:form id="loginForm" name="loginpage" style="text-align: -webkit-center;"
				modelAttribute="loginObject" action="loginProcess" method="post"> --%>
		
		
		<form name='loginpage'
		
		
		
		
		
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
		   
				<div class="form-group" style="width: 60%">
					Username:
					<!-- path is similar to variable which holds user entered values  -->
					<input type='text' name="username" id="username" />
				</div>

				<div class="form-group" style="width: 60%">
					Password:
					<input type='password' name="password" id="password" />
				</div>
				
				<!-- Configuring CSRF Protection -->
 				<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				
				<!-- Submit Button, Login is a label(Button name) -->
				<%-- <form:button style="margin-left: 50%;" 
					id="login" name="login"></form:button> --%>
					<input class="btn btn-primary" name="Login" type="submit"
				  value="submit" />
			</form>

			
			<!-- Register Button link -->
			<a href="registeruser"><button style="margin:10px"
					class="btn btn-primary">Register</button></a>
		
			<div style="font-style: italic; color: red;">${message}</div>
		</div>
	</div>
</body>
</html>