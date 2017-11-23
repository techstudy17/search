package com.ibs.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.dto.FlightSearchDTO;
import com.ibs.expection.FlightSearchException;
import com.ibs.model.FlightScheduler;
import com.ibs.service.FlightSearchService;
import com.ibs.xmlparsandehcache.FlightSearchEHCache;
/**
 * 
 * @author Sumya
 *
 */
@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	private static final Logger logger = Logger.getLogger(FlightSearchServiceImpl.class.getName());

	@Autowired
	FlightSearchEHCache flightSearchEHCache;
	
	public List<FlightScheduler> search(FlightSearchDTO searchDTO) throws FlightSearchException {
		String response = null;
		List<FlightScheduler> flightSchedulers = null;
		try {
			 StringBuilder stringBuilder = new StringBuilder();
	            stringBuilder.append(searchDTO.getOrigin());
	            stringBuilder.append(searchDTO.getDestination());
	            stringBuilder.append(searchDTO.getDeparturedate());
	            String finalSearchKey = stringBuilder.toString();
	            
			Map<String, FlightScheduler> flightSchedulerMap = flightSearchEHCache.FlightSearch();
			flightSchedulers = new ArrayList<>();
			for (Map.Entry<String, FlightScheduler> entry : flightSchedulerMap.entrySet()) {
				if(entry.getKey().contains(finalSearchKey)){
					flightSchedulers.add(entry.getValue());
				}
			}
		
		}
		catch (Exception exception) {
			logger.error("Error", exception);
		}
		return flightSchedulers;
	}
}
