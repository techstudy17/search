<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS Bootstrap links -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Currency Converter</title>

<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<link rel="stylesheet"
	href="/flightscheduler/resources/css/hotelbooking.css">
	
<!-- Local JS and CSS used in this page -->
<script src="/flightscheduler/resources/js/flightscheduler.js"></script>

</head>
<body>
<sec:authorize access="hasRole('ROLE_USER')">
<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
		

		<c:if test="${pageContext.request.userPrincipal.name != null}">
		<div class="topnav">
		<a class="active" href="javascript:formSubmit()"> Logout</a>
		</div>
<div class="container" style="min-height: 300px">

	<div class="starter-template">
		<h3 style="color: blue">Schedule Flight</h3>

		<div id="feedback"></div>

		<form class="form-horizontal" id="flight-scheduler-form" name="flight-scheduler-name">
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Departure Date</label>
				<div class="col-sm-3">
					<input class="form-control" style="text-align: center;" type="text" id="datepicker" name="departure">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Origin</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="originID" name="origin">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Destination</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="destinationID" name="destination">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Connector</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="connectorID" name="connector">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Flight Number</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="flightnumberID" name="flightnumber">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Flight Codes</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="careerCodeID" name="careercode">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Booking Class</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="bookingclassID" name="bookingclass">
				</div>
			</div>
			
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label" style="color: blue">Availability</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="availabilityID" name="availability">
				</div>
			</div>
						
					<br>
					<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Schedule Flight</button>
				</div>
			</div>
</form>
		<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8" style="margin-top: -5%">
					<a href="/flightscheduler/"><button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Reset</button></a>
				</div>
			</div>
			<div  id="errorDisplay" style="display: none; color: white;background-color: red;height: 40px;text-align: center;margin-left: 51%;margin-top: -30%;"></div>
			<div  id="successID" style="display: none; color: white;background: rgb(18, 70, 128);height: 40px;text-align: center;margin-left: 51%;margin-top: -30%;width: 30%"></div>
	</div>
</div>

<div id="divToShowResult"></div>
</c:if>
	</sec:authorize>
</body>
</html>