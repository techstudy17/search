package com.ibs.service;

import com.ibs.dto.FlightSchedulerDTO;
import com.ibs.expection.FlightScheduleException;
/**
 * 
 * @author Sumya
 *
 */
public interface FlightSchedulerService {

	public String messageSenderToJMS(FlightSchedulerDTO flightSchedulerDTO) throws FlightScheduleException;
}
