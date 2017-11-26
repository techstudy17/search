package com.ibs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibs.dto.FlightSchedulerDTO;
import com.ibs.expection.FlightScheduleException;
import com.ibs.service.FlightSchedulerService;
import com.ibs.util.Constants;

/**
 * 
 * @author Sumya
 *
 */
@RestController
public class FlightScheduleController {
	
	@Autowired
	FlightSchedulerService flightSchedulerService;
	
	
	private static final Logger logger = Logger.getLogger(FlightScheduleController.class.getName());
	

	
	/**
	 * Takes Flight schedule parameters from GUI and 
	 * converts the schdule to xml format and pushs the 
	 * same into the queue. 
	 *
	 * @param flightSchedulerDTO holds flight schedule values.
	 */
	@RequestMapping(value = "/scheduleflight", method = RequestMethod.POST)
	public String scheduleFlight(@RequestBody FlightSchedulerDTO flightSchedulerDTO) {
		String response = null;
		try {
			response = flightSchedulerService.messageSenderToJMS(flightSchedulerDTO);
		} catch (FlightScheduleException flightScheduleException) {
			response = flightScheduleException.getMessage();
			logger.error("Error", flightScheduleException);
		}
		catch (Exception exception) {
			response = exception.getMessage();
			logger.error("Error", exception);
		}
		return response;
	}
}
