package com.ibs.util;

import com.ibs.dto.FlightSchedulerDTO;
import com.ibs.model.FlightScheduler;
/**
 * 
 * @author Sumya
 *
 */
public class FlightSchedulerUtility {

	public static FlightScheduler convertDTOToJaxBObject(FlightSchedulerDTO flightSchedulerDTO){
		FlightScheduler flightScheduler = new FlightScheduler();
		flightScheduler.setAvailability(flightSchedulerDTO.getAvailability());
		flightScheduler.setBookingclass(flightSchedulerDTO.getBookingclass());
		flightScheduler.setDeparturedate(flightSchedulerDTO.getDeparturedate());
		flightScheduler.setDestination(flightSchedulerDTO.getDestination());
		flightScheduler.setFlightnumber(flightSchedulerDTO.getFlightnumber());
		flightScheduler.setOrigin(flightSchedulerDTO.getOrigin());
		flightScheduler.setConnector(flightSchedulerDTO.getConnector());
		flightScheduler.setCareercode(flightSchedulerDTO.getCareercode());
		return flightScheduler;
	}
}
