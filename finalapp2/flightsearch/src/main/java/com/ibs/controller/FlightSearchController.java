package com.ibs.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibs.dto.FlightSearchDTO;
import com.ibs.expection.FlightSearchException;
import com.ibs.model.FlightScheduler;
import com.ibs.service.FlightSearchService;
import com.ibs.util.Constants;

/**
 * 
 * @author Sumya
 *
 */
@RestController
public class FlightSearchController {
	
	@Autowired
	FlightSearchService flightSchedulerService;
	
	
	private static final Logger logger = Logger.getLogger(FlightSearchController.class.getName());
	
	@RequestMapping(value = "/searchflight", method = RequestMethod.POST)
	public List<FlightScheduler> scheduleFlight(@RequestBody FlightSearchDTO flightSchedulerDTO) {
		List<FlightScheduler> response = new ArrayList<>();
		try {
			response = flightSchedulerService.search(flightSchedulerDTO);
			
		} catch (FlightSearchException flightScheduleException) {
			logger.error("Error", flightScheduleException);
		}
		catch (Exception exception) {
			logger.error("Error", exception);
			return response;
		}
		return response;
	}
}
