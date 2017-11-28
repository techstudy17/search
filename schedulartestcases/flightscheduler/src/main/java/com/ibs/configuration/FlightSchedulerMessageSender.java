package com.ibs.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.ibs.controller.FlightScheduleController;
import com.ibs.expection.FlightScheduleException;
import com.ibs.model.FlightScheduler;
import com.ibs.util.Constants;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
/**
 * 
 * @author Sumya
 *
 */
@Component
public class FlightSchedulerMessageSender {

	private static final Logger logger = Logger.getLogger(FlightSchedulerMessageSender.class.getName());
	
    @Autowired
    private JmsTemplate jmsTemplate;

    public String sendMessage(final FlightScheduler flightScheduler) throws FlightScheduleException {
    	String respnse = null;
    	try{
    	jmsTemplate.convertAndSend(flightScheduler);
        respnse = Constants.SUCCESSS;
    	}catch(Exception exception)
    	{
    		logger.error(Constants.ERROR,exception);
    		throw new FlightScheduleException(Constants.JMS_TEMPLATE_SEND_MESSAGE_ERROR);
    	}
    	return respnse;
    }
}