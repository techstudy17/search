package com.ibs.configuration;


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

import com.ibs.model.AvalilablityAndClassDetails;
import com.ibs.model.FlightScheduler;
import com.ibs.util.Constants;
 
@Component
public class MessageReceiver implements MessageListener{
	
	private static final Logger logger = Logger.getLogger(MessageReceiver.class.getName());
	
	public static Map<String,FlightScheduler> flightSchedulerMap = null;
	
     
    @Autowired
    MessageConverter messageConverter;
     
    @Override
    public void onMessage(Message message) {
        try {
        	if(flightSchedulerMap==null){
        	flightSchedulerMap = new HashMap<String,FlightScheduler>();
        	}
            FlightScheduler response = (FlightScheduler) messageConverter.fromMessage(message);
            
            messageProcessor(response);
            
        } catch (JMSException exception) {
        	logger.error(Constants.ERROR,exception);
        }
         
    }
    
    private synchronized void messageProcessor(FlightScheduler flightScheduler){
    	StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(flightScheduler.getOrigin());
        stringBuilder.append(flightScheduler.getDestination());
        stringBuilder.append(flightScheduler.getDeparturedate());
        
        //Changed connector to show only direct or indirect based on selected. Default direct is selected.
        if(flightScheduler.getConnector()!=null&&flightScheduler.getConnector()!="")
        {
        stringBuilder.append(flightScheduler.getConnector());
        }
        stringBuilder.append(flightScheduler.getCareercode());
        stringBuilder.append(flightScheduler.getFlightnumber());
        String finalKey = stringBuilder.toString();
        
        FlightScheduler ScheduledFlightFromMap = flightSchedulerMap.get(finalKey);
        logger.info("finalKey"+finalKey);
        System.out.println("ScheduledFlightFromMap"+ScheduledFlightFromMap);
        List<AvalilablityAndClassDetails> avalilablitiesFromQueue = flightScheduler.getAvalilablityList();
        AvalilablityAndClassDetails avalilablityFromQueue = avalilablitiesFromQueue.get(0);
        StringBuilder availablestringBuilder = new StringBuilder();
        if(ScheduledFlightFromMap!=null)
        {
        	if(flightScheduler.getScheduletime()>ScheduledFlightFromMap.getScheduletime())
        	{
        	Boolean isAvailableUpdated = false;
        for(AvalilablityAndClassDetails avalilablityAndClassDetailsforClass:ScheduledFlightFromMap.getAvalilablityList())
        {
        	if(avalilablityAndClassDetailsforClass.getBookingClass().equals(avalilablityFromQueue.getBookingClass()))
        	{
        		avalilablityAndClassDetailsforClass.setAvailableSeats(avalilablityFromQueue.getAvailableSeats());
        		isAvailableUpdated = true;
        	}
        }
        //Optimized after removing new and using existing avalilablityFromQueue coming from ActiveMQ.
        //Since we are getting avalilablityFromQueue object from avalilablitiesFromQueue.get(0) 
        //which is coming from activeMQ and we know we want to do add class and availability direst 
        //we can store avalilablityFromQueue to map's object.
        if(!isAvailableUpdated){
        	List<AvalilablityAndClassDetails> avalilablityAndClassDetails = ScheduledFlightFromMap.getAvalilablityList();
        	avalilablityAndClassDetails.add(avalilablityFromQueue);
    	}
        
        for(AvalilablityAndClassDetails avalilablityAndClassDetails:ScheduledFlightFromMap.getAvalilablityList())
        {
        	availablestringBuilder.append(avalilablityAndClassDetails.getBookingClass());
        	availablestringBuilder.append("(");
        	availablestringBuilder.append(avalilablityAndClassDetails.getAvailableSeats());
        	availablestringBuilder.append(")");
        	availablestringBuilder.append(",");
        }
        ScheduledFlightFromMap.setAvailabileClassAndSeats(availablestringBuilder.toString());
        flightSchedulerMap.put(finalKey,ScheduledFlightFromMap);
        }
        }
        else{
        	availablestringBuilder.append(avalilablityFromQueue.getBookingClass());
        	availablestringBuilder.append("(");
        	availablestringBuilder.append(avalilablityFromQueue.getAvailableSeats());
        	availablestringBuilder.append(")");
        	flightScheduler.setAvailabileClassAndSeats(availablestringBuilder.toString());
        	flightSchedulerMap.put(finalKey,flightScheduler);
        }
       
        logger.info("flightSchedulerMap"+flightSchedulerMap);
        logger.info("Application : flight schedule response received : {}"+flightScheduler);    
    }
    public static Map<String,FlightScheduler> getFlightSchedulers() {
    	//If any message is not scheduled to ActiveMQ and search is happening at that time then below map will be null that 
    	//time because we are initializing map on Message only which executes when message comes from ActiveMQ. 
    	//To solve that issue we are initializing below and map will be initailized only only once because we are checking null.
    	if(flightSchedulerMap==null){
        	flightSchedulerMap = new HashMap<String,FlightScheduler>();
        	}
		return flightSchedulerMap;
	}
}	