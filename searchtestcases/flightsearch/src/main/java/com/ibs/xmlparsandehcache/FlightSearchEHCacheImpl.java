package com.ibs.xmlparsandehcache;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ibs.configuration.MessageReceiver;
import com.ibs.model.FlightScheduler;
import com.ibs.util.Constants;
/**
 * 
 * @author Sumya
 *
 */
@Service
@SuppressWarnings("all")
public class FlightSearchEHCacheImpl implements FlightSearchEHCache {

	private static final Logger logger = Logger.getLogger(FlightSearchEHCacheImpl.class.getName());

	@Autowired
	MessageReceiver messageReceiver;
	
	/**
	 * Returns a CurrencyConverter which holds from currency, to currency,
	 * amount and converted amount. It is a spring EHCache method which caches
	 * parsed values from static xml.
	 *
	 * @return CurrencyConverterDTO
	 */
	@Cacheable("flightScheduleCache")
	public Map<String,FlightScheduler> FlightSearch() {
		logger.info("===========flightScheduleCache==================");
		Map<String,FlightScheduler> flightSchedulerMap = null;
		try {
			flightSchedulerMap = messageReceiver.getFlightSchedulers();
		} catch (Exception exception) {
			logger.error(Constants.ERROR, exception);
		}
		return flightSchedulerMap;
	}

}
