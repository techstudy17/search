package com.ibs.service;

import java.util.List;

import com.ibs.dto.FlightSearchDTO;
import com.ibs.expection.FlightSearchException;
import com.ibs.model.FlightScheduler;
/**
 * 
 * @author Sumya
 *
 */
public interface FlightSearchService {

	public List<FlightScheduler> search(FlightSearchDTO flightSchedulerDTO) throws Exception;
}
