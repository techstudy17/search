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
	$('.radioclass').click(function() {
		   if($('#indirectID').is(':checked')) { 
			  $("#connectorDiv").show();
			   }
		   if($('#directID').is(':checked')) { 
			   $("#connectorDiv").hide();
			   $("#connectorID").val("");
			   }
		});
	
	$.validator.addMethod('origincheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value)&&/^.{0,3}$/.test(value);
	}, 'Please enter a valid Origin');
	
	$.validator.addMethod('destinationcheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value)&&/^.{0,3}$/.test(value);
	}, 'Please enter a valid Destination');
	
	$.validator.addMethod('connectorcheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z()]+$/.test(value);
	}, 'Please enter a valid Connector');
	
	$.validator.addMethod('careercodecheck', function (value, element) { 
	    return this.optional(element) || /^[a-zA-Z0-9()]+$/.test(value)&&/^.{0,2}$/.test(value);
	}, 'Please enter a valid Career Code');
	
  $("form[name='flight-search-name']").validate({
    rules: {
    	OriginName : {
			
			origincheck: "required origincheck",
		 
		},
		DestinationName : {
			
			destinationcheck: "required destinationcheck",
		 
		},
		FlightCodeName : {
			
			careercodecheck : "required careercodecheck",
			 
		},
		ConnectorName : {
			
			connectorcheck: "reqired connectorcheck",
		}
    },
 
  });
    
    $("#flight-search-form").submit(function(event) {

    	// Prevent the form from submitting via the browser.
		event.preventDefault();
	
		var checkValidation = false;
		if($("form[name='flight-search-name']").valid()){
			checkValidation = true;
		}
		
		if(checkValidation){
			 $("#tableheader").hide();
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
				 $("#tableheader").show();
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
		});

	}

	function display(data) {
			if(data.length>0){
				$('#errorDisplay').hide();
				$('#flightSearchResult').show();
			 $('#flightSearchResult').DataTable( {
			        data: data,
			        destroy: true,
			        columns: [
            { data: 'origin' },
            { data: 'destination' },
            { data: 'connector' },
            { data: 'departuredate' },
            { data: 'flightnumber' },
            { data: 'availabileClassAndSeats' },
			        ]
			    } );
	}else{
		$('#flightSearchResult').hide();
		$('#errorDisplay').text("No matching flights are available");
		$('#errorDisplay').show();
	}
	}
  });