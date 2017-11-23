
$(function() {
	
	$.validator.addMethod('origincheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value);
	}, 'Please enter a valid Origin');
	
	$.validator.addMethod('destinationcheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value);
	}, 'Please enter a valid Destination');
	
	$.validator.addMethod('connectorcheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value);
	}, 'Please enter a valid Connector');
	
	$.validator.addMethod('flightnumbercheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z0-9()]+$/.test(value);
	}, 'Please enter a valid Flight Number');
	
	$.validator.addMethod('bookingclasscheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value);
	}, 'Please enter a valid Booking Class');
	
	$.validator.addMethod('careercodecheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z0-9()]+$/.test(value);
	}, 'Please enter a valid Career Code');
	
  $("form[name='flight-scheduler-name']").validate({
    rules: {
    	departure : {
		required: true,
		 
    	},
    	origin : {
			required: true,
			origincheck: "required origincheck",
		 
		},
		destination : {
			required: true,
			destinationcheck: "required destinationcheck",
		 
		},
    	flightnumber : {
			required: true,
			flightnumbercheck: "required flightnumbercheck",
		 
		},
		bookingclass : {
			required: true,
			bookingclasscheck : "required bookingclasscheck",
		},
		availability : {
			required: true,
			 number: true
			 
		},
		careercode : {
			required: true,
			careercodecheck : "required careercodecheck",
			 
		},
		connector : {
			required: true,
			connectorcheck: "reqired connectorcheck",
		}
    },
    messages: {
    	departure : {
			required : "Please Enter a Departure Date",
		},
		origin : {
			required : "Please Enter a Origin",
		},
		destination : {
			required : "Please Enter a Destination",
			
		},
		flightnumber : {
			required : "Please Enter a Flight Number",
			
		},
		bookingclass : {
			required : "Please Enter a Booking Class",
			
		},
		availability : {
			required : "Please Enter Availability",
			 number: "Please enter a valid Availability value"
			
		},careercode : {
			required : "Please Enter a Career Code",
		}
		,connector : {
			required : "Please Enter a Connector Code",
			
		}
    },
  });
    
    $("#flight-scheduler-form").submit(function(event) {

    	// Prevent the form from submitting via the browser.
		event.preventDefault();
		$('#successID').hide();
		$('#errorDisplay').hide();
		
		var checkValidation = false;
		if($("form[name='flight-scheduler-name']").valid()){
			checkValidation = true;
		}
		
		if(checkValidation){
		schedulerAjaxCall();
		}

	});
    
    
	function schedulerAjaxCall() {

		var schedulerJSON = {}
		schedulerJSON["departuredate"] = $("#datepicker").val();
		schedulerJSON["origin"] = $("#originID").val();
		schedulerJSON["destination"] = $("#destinationID").val();
		schedulerJSON["flightnumber"] = $("#flightnumberID").val();
		schedulerJSON["bookingclass"] = $("#bookingclassID").val();
		schedulerJSON["availability"] = $("#availabilityID").val();
		schedulerJSON["connector"] = $("#connectorID").val();
		schedulerJSON["careercode"] = $("#careerCodeID").val();
		
		var baseUrl = document.location.origin;
		var finalUrlToHit = baseUrl+"/flightscheduler/scheduleflight";
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : finalUrlToHit,
			data : JSON.stringify(schedulerJSON),
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
		});

	}

	function display(data) {
		var htmlWidgetString = data;
		if(data === 'success'){
			$('#successID').show();
			$('#successID').text('Flight Successfully Scheduled');
			$('#errorDisplay').hide();
		}else{
			$('#successID').hide();
			$('#errorDisplay').text(data);
			$('#errorDisplay').show();
		}
	}
  });

$(document).ready(function() {
	$(function() {
		var currentDate = new Date();
	    $('#datepicker').datepicker({
	        inline: true,
	        showOtherMonths: true,
	        dayNamesMin: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
	        dateFormat: 'dd/mm/yy',
	        minDate: 0
	    });
	    $("#datepicker").datepicker("setDate", currentDate);
	
	});
	});