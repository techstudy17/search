package com.ibs.serviceimpl;

import java.io.StringWriter;

import javax.xml.bind.JAXB;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

import com.ibs.configuration.FlightSchedulerConfig;
import com.ibs.configuration.FlightSchedulerMessageSender;
import com.ibs.dto.FlightSchedulerDTO;
import com.ibs.expection.FlightScheduleException;
import com.ibs.model.FlightScheduler;
import com.ibs.service.FlightSchedulerService;
import com.ibs.util.Constants;
import com.ibs.util.FlightSchedulerUtility;
/**
 * 
 * @author Sumya
 *
 */
@Service
public class FlightSchedulerServiceImpl implements FlightSchedulerService {

	private static final Logger logger = Logger.getLogger(FlightSchedulerServiceImpl.class.getName());

	@Override
	public String messageSenderToJMS(FlightSchedulerDTO flightSchedulerDTO) throws FlightScheduleException {
		String response = null;
		
		try {
			FlightScheduler flightScheduler = FlightSchedulerUtility.convertDTOToJaxBObject(flightSchedulerDTO);
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FlightSchedulerConfig.class);
			FlightSchedulerMessageSender flightSchedulerMessageSender = context
					.getBean(FlightSchedulerMessageSender.class);

			StringWriter stringWriter = new StringWriter();
			JAXB.marshal(flightScheduler, stringWriter);
			String flightScheduleMessageInXML = stringWriter.toString();
			response = flightSchedulerMessageSender.sendMessage(flightScheduleMessageInXML);

		}
		catch (FlightScheduleException flightScheduleException) {
			logger.error("Error", flightScheduleException);
			throw new FlightScheduleException(flightScheduleException.getMessage());
		}
		catch (Exception exception) {
			logger.error("Error", exception);
		}
		return response;
	}
}
