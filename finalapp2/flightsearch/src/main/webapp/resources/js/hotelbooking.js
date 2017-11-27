//For Search Save button call
function hotelSelectFunction(hotelID,hotelName) {
	$("#searchHotel").html('Save');
	$("#selectedhotelDivID").show();
	$("#selectedhotelID").prop('type', 'text');
	$("#selectedhotelID").prop('value', hotelName);
	
}

//For Edit button call. Page on load
function hotelBookingEditFunction() {
	var selectedHotelNameCheckVariable = document.getElementById('selectedhotelID').value;
   if(selectedHotelNameCheckVariable!=''){
	   $("#searchHotel").html('Save');
	   $("#searchResultTRid").hide();
	   $("#selectedhotelDivID").show();
		$("#selectedhotelID").prop('type', 'text');
		$("#selectedhotelID").prop('value', hotelName);
   }
}

$(function() {
	//Validation For Registration page Form
  $("form[name='registrationpage']").validate({
    rules: {
    	firstname: "required",
    	lastname: "required",
      username: "required",
      address: "required",
      phone: {
    	  required: true,
          digits: true,
          minlength: 10
        },
      email: {
        required: true,
        email: true
      },
      password: {
        required: true,
        minlength: 5
      }
    },
    messages: {
    	address: "Please enter your address",
      firstname: "Please enter your firstname",
      lastname: "Please enter your lastname",
      username: "Please enter your username",
      password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
      },
      phone: {
          required: "Please provide a phone number",
          minlength: "Your phone must be a digit with length 10"
        },
      email: "Please enter a valid email address"
    },
    
    submitHandler: function(form) {
      form.submit();
    }
  });
  
//Validation For Login page Form
  $("form[name='loginpage']").validate({
	    rules: {
	    	username: "required",
	      password: {
	        required: true,
	        minlength: 5
	      }
	    },
	    messages: {
	    	username: "Please enter your username",
	      password: {
	        required: "Please provide a password",
	        minlength: "Your password must be at least 5 characters long"
	      },
	    },
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
  
//Validation For Search page Form
  $("form[name='searchpage']").validate({
		    rules : {

			hotelareaname : {
				required : true,
			},
			roomcount : {
				required: true,
			      digits: true
			},
			guestcount : {
				required: true,
			      digits: true
			},
			fromdate : {
				 required: true,
			      date: true
			},
			todate : {
				 required: true,
			      date: true
			},

		},
			    messages : {
			roomcount : {
				required : "Please enter roomcount",
				digits : "Please enter valid count"
			},
			guestcount : {
				required : "Please enter guestcount",
				digits : "Please enter valid count"
			},
			todate : {
				required : "Please enter date",
				date : "Please enter valid date"
			},
			fromdate : {
				required : "Please enter date",
				date : "Please enter valid date"
			},
			hotelareaname : {
				required : "Please enter City, Hotel or Area name",
			},
	    },
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
});
