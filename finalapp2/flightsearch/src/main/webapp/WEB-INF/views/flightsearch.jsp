<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Flight Search</title>

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css" />

<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>

<link rel="stylesheet"
	href="/flightsearch/resources/css/flightsearch.css">

<link rel="stylesheet"
	href="/flightsearch/resources/css/hotelbooking.css">

<!-- Local JS and CSS used in this page -->
<script src="/flightsearch/resources/js/flightscheduler.js"></script>

<script src="/flightsearch/resources/js/flightsearch.js"></script>

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
			<div class="container"
				style="background-image: url('/flightsearch/resources/airport.jpg'); background-size: 857px 370px; background-repeat: no-repeat; text-align: color: black; background-color: lightblue; width: 850px; height: 350px; margin-top: 20px; margin-bottom: 20px; margin-right: 250px; margin-left: 250px;">
				<h2 style="color: black">Search Domestic and International
					Flights</h2>

				<form class="form-horizontal" id="flight-search-form"
					name="flight-search-name">
					<label style="color: black; margin-left: 13%;"
						class="control-label"> <input type="radio" id="directID"
						class="radioclass" name="dirctcheck" value="direct">Direct
					</label> <label style="color: black" class="control-label"> <input
						type="radio" id="indirectID" class="radioclass" name="dirctcheck"
						value="indirect">In direct
					</label> <br> <br>
					<div class="form-group form-group-lg">
						<label class="col-sm-1 control-label" style="color: black">Origin</label>
						<div class="col-sm-5">
							<input style="margin-bottom: 3px;" id="originID"
								name="OriginName" placeholder="City or Airport"
								class="form-control" />
						</div>

						<label class="col-sm-1 control-label" style="color: black">Destination</label>
						<div class="col-sm-5">
							<input style="margin-bottom: 3px;" id="destinationID"
								name="DestinationName" placeholder="City or Airport"
								class="form-control" />
						</div>
					</div>
					<div class="form-group form-group-lg row">

						<label class="col-sm-2 control-label" style="color: black;">Flight
							Code</label>
						<div class="col-sm-3">
							<input placeholder="Flight Code" id="flightCodeID"
								name="FlightCodeName" class="form-control" />
						</div>

						<label class="col-sm-3 control-label" style="color: black">Departure
							Date</label>
						<div class="col-sm-3">
							<input class="form-control" style="text-align: center;"
								id="datepicker" name="DepartureDateName" type="text"
								id="datepicker" name="departure">
						</div>
					</div>
					<div class="form-group form-group-lg row" id="connectorDiv"
						style="display: none">
						<label class="col-sm-2 control-label" style="color: black;">Connector</label>
						<div class="col-sm-3">
							<input placeholder="City or Airport" id="connectorID"
								name="ConnectorName" class="form-control" />
						</div>
					</div>

					<input style="margin-left: 60%" value="Search Flight"
						class="btn btn-danger btn-lg" type="submit" />
				</form>
				<div  id="errorDisplay" style="display: none; color: white;background-color: red;height: 40px;text-align: center;margin-top: 2%;"></div>
			</div>
			
			<table id="flightSearchResult" class="display" style="width: 100%">
				<thead>
					<tr id="tableheader" style="display: none">
						<th>Origin</th>
						<th>Destination</th>
						<th>Connector</th>
						<th>Departure Date</th>
						<th>Flight Number</th>
						<th>Available</th>
					</tr>
				</thead>
			</table>
		</c:if>
			</sec:authorize>
</body>	
</html>