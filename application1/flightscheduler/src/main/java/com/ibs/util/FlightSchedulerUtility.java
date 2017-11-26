package com.ibs.util;

import java.util.ArrayList;
import java.util.List;

import com.ibs.dto.FlightSchedulerDTO;
import com.ibs.model.AvalilablityAndClassDetails;
import com.ibs.model.FlightScheduler;
/**
 * 
 * @author Sumya
 *
 */
public class FlightSchedulerUtility {

	public static FlightScheduler convertDTOToJaxBObject(FlightSchedulerDTO flightSchedulerDTO){
		FlightScheduler flightScheduler = new FlightScheduler();
		
		List<AvalilablityAndClassDetails> avalilablityAndClassDetailsList = new ArrayList<AvalilablityAndClassDetails>();
		AvalilablityAndClassDetails avalilablityAndClassDetails = new AvalilablityAndClassDetails();
		avalilablityAndClassDetails.setAvailableSeats(flightSchedulerDTO.getAvailability());
		avalilablityAndClassDetails.setBookingClass(flightSchedulerDTO.getBookingclass());
		avalilablityAndClassDetailsList.add(avalilablityAndClassDetails);
		flightScheduler.setAvalilablityList(avalilablityAndClassDetailsList);;

		flightScheduler.setDeparturedate(flightSchedulerDTO.getDeparturedate());
		flightScheduler.setDestination(flightSchedulerDTO.getDestination());
		flightScheduler.setFlightnumber(flightSchedulerDTO.getFlightnumber());
		flightScheduler.setOrigin(flightSchedulerDTO.getOrigin());
		flightScheduler.setConnector(flightSchedulerDTO.getConnector());
		flightScheduler.setCareercode(flightSchedulerDTO.getCareercode());
		return flightScheduler;
	}
}
