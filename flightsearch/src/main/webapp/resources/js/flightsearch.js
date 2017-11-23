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
	
  $("form[name='flight-search-name']").validate({
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
    
    $("#flight-search-form").submit(function(event) {

    	// Prevent the form from submitting via the browser.
		event.preventDefault();
		$('#successID').hide();
		$('#errorDisplay').hide();
		
		var checkValidation = false;
		if($("form[name='flight-search-name']").valid()){
			checkValidation = true;
		}
		
		if(true){
			searchAjaxCall();
		}

	});
    
    
	function searchAjaxCall() {

		var schedulerJSON = {}
		
		schedulerJSON["dierct"] = $("input[name='dirctcheck']").val();
		schedulerJSON["origin"] = $("#originID").val();
		schedulerJSON["destination"] = $("#destinationID").val();
		schedulerJSON["flightcode"] = $("#flightCodeID").val();
		schedulerJSON["departuredate"] = $("input[name='DepartureDateName']").val();
		schedulerJSON["connector"] = $("#connectorID").val();
		
		var baseUrl = document.location.origin;
		var finalUrlToHit = baseUrl+"/flightsearch/searchflight";
		
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
			
			 $('#flightSearchResult').DataTable( {
			        data: data,
			        columns: [
            { data: 'origin' },
            { data: 'destination' },
            { data: 'departuredate' },
            { data: 'flightnumber' },
            { data: 'connector' },
            { data: 'availability' },
            { data: 'bookingclass' },
			        ]
			    } );
	}
  });