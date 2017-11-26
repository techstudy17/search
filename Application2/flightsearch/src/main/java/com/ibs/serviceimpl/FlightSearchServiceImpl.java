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
import com.ibs.util.Constants;
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
	
	public List<FlightScheduler> search(FlightSearchDTO searchDTO) throws Exception {
		List<FlightScheduler> flightSchedulers = null;
		List<FlightScheduler> flightSchedulerAll = null;
	
			 StringBuilder stringBuilder = new StringBuilder();
	            stringBuilder.append(searchDTO.getOrigin());
	            stringBuilder.append(searchDTO.getDestination());
	            stringBuilder.append(searchDTO.getDeparturedate());
	            stringBuilder.append(searchDTO.getFlightcode());
	            if(searchDTO.getConnector()!=null&&searchDTO.getConnector()!="")
	            {
	            	 stringBuilder.append(searchDTO.getConnector());
	            }
	            String finalSearchKey = stringBuilder.toString();
	            logger.info("============finalSearchKey=========="+finalSearchKey);
	         
			Map<String, FlightScheduler> flightSchedulerMap = flightSearchEHCache.FlightSearch();
			logger.info("Map from Cache"+flightSchedulerMap);
			flightSchedulers = new ArrayList<>();
			flightSchedulerAll = new ArrayList<>();
			for (Map.Entry<String, FlightScheduler> entry : flightSchedulerMap.entrySet()) {
				logger.info("============mapKey=========="+entry.getKey());
				if(entry.getKey().contains(finalSearchKey)){
					flightSchedulers.add(entry.getValue());
				}
				flightSchedulerAll.add(entry.getValue());
			}
		
			if (searchDTO.getOrigin() == null || searchDTO.getOrigin() == "" && searchDTO.getDestination() == null
					|| searchDTO.getDestination() == "" && searchDTO.getFlightcode() == null
					|| searchDTO.getFlightcode() == "")
	         {
				if(flightSchedulerAll.isEmpty()){
					throw new FlightSearchException(Constants.FLIGHT_NOT_AVAILABLE);
				}
	        	  return flightSchedulerAll;
	         }
	
		return flightSchedulers;
	}
}
