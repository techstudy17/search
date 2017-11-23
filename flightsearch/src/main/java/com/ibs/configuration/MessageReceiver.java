package com.ibs.configuration;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.ibs.model.FlightScheduler;
import com.ibs.serviceimpl.FlightSearchServiceImpl;
import com.ibs.util.Constants;

import net.sf.ehcache.hibernate.management.impl.CollectionStats;
 
@Component
public class MessageReceiver implements MessageListener{
	
	private static final Logger logger = Logger.getLogger(MessageReceiver.class.getName());
	
	public static Map<String,FlightScheduler> flightSchedulerMap = null;
	
    public MessageReceiver() {
		flightSchedulerMap = new HashMap<String,FlightScheduler>();
	}
     
    @Autowired
    MessageConverter messageConverter;
     
    @Override
    public void onMessage(Message message) {
        try {
        	logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            FlightScheduler response = (FlightScheduler) messageConverter.fromMessage(message);
            
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(response.getOrigin());
            stringBuilder.append(response.getDestination());
            stringBuilder.append(response.getDeparturedate());
            stringBuilder.append(response.getFlightnumber());
            stringBuilder.append(response.getBookingclass());
            String finalKey = stringBuilder.toString();
            logger.info("finalKey"+finalKey);
            flightSchedulerMap.put(finalKey,response);
            logger.info("flightSchedulerMap"+flightSchedulerMap);
            logger.info("Application : flight schedule response received : {}"+response);    
            logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (JMSException exception) {
        	logger.error(Constants.ERROR,exception);
        }
         
    }
    public static Map<String,FlightScheduler> getFlightSchedulers() {
		return flightSchedulerMap;
	}
}