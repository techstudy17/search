package com.ibs.configuration;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.ibs.model.FlightScheduler;

/**
 * 
 * @author Sumya
 *
 */
@Configuration
@ComponentScan
@EnableJms
public class FlightSearchConfig {

	private static final Logger logger = Logger.getLogger(FlightSearchConfig.class.getName());

	public static final String QUEUE_NAME = "flightscheduler.queue";

	@Autowired
	MessageReceiver messageReceiver;

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connectionFactory.setTrustedPackages(Arrays.asList("com.ibs.model"));
		} catch (Exception exception) {
			logger.error("Error", exception);
		}

		return connectionFactory;
	}

	@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = null;
		try {
			factory = new DefaultJmsListenerContainerFactory();
			factory.setConnectionFactory(connectionFactory());
			// core poll size=4 threads and max poll size 8 threads
			factory.setConcurrency("4-8");
		} catch (Exception exception) {
			logger.error("Error", exception);
		}
		return factory;
	}

	/*
	 * Message listener container, used for invoking messageReceiver.onMessage
	 * on message reception.
	 */
	@Bean
	public MessageListenerContainer getContainer() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(QUEUE_NAME);
		container.setMessageListener(messageReceiver);
		return container;
	}

	/*
	 * Used for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(QUEUE_NAME);
		return template;
	}
	/*
	 * Used for Message Converter.
	 */
	@Bean
	MessageConverter converter() {
		return new SimpleMessageConverter();
	}

}
