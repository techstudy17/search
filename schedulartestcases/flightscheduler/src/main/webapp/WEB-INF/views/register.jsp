<!-- JSP tags links -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<!-- Meta Information -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Title comes in browser tab -->

<!-- Local CSS and JS used in this page -->
<script src="/flightscheduler/resources/js/hotelbooking.js"></script>
<link rel="stylesheet"
	href="/flightscheduler/resources/css/hotelbooking.css">
<title>Hotel Booking</title>

</head>


<body style="background-image: url('/flightscheduler/resources/hotel.jpg');">

	<!-- Below code will appear on top for Home and Register -->
	<div class="topnav">
		<a class="active" href="/flightscheduler/">Home</a>
	</div>

	<div class="container">
		<div class="jumbotron" id="registerjumbo">

			<!-- modelAttribute holds object sent from controller (modelAndViewForRegister.addObject("user", new User());) 
			and action will form URL and access controller -->

			<form:form id="regForm" name="registrationpage" modelAttribute="userRegistrationObject"
				action="registerProcess" method="post">

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> Username:</label>
					<!-- path is similar to variable which holds user entered values  -->
					<form:input path="username" name="username" id="username" />
				</div>

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> Password:</label>
					<form:password path="password" name="password" id="password" />
				</div>

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> FirstName:</label>
					<form:input path="firstname" name="firstname" id="firstname" />
				</div>

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> LastName:</label>
					<form:input path="lastname" name="lastname" id="lastname" />
				</div>

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> Email:</label>
					<form:input path="email" name="email" id="email" />
				</div>

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> Address:</label>
					<form:input path="address" name="address" id="address" />
				</div>

				<div class="form-group registerDiv">
					<label class="col-sm-2 control-label" for="lg"> Phone:</label>
					<form:input path="phone" name="phone" id="phone" />
				</div>

				<form:button id="register" name="register">Register</form:button>

			</form:form>
				<div style="font-style: italic; color: red;">${message}</div>
		</div>
	</div>
</body>
</html>