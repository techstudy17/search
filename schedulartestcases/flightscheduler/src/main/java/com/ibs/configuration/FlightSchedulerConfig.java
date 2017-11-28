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
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/**
 * 
 * @author Sumya
 *
 */
@Configuration
@ComponentScan
@EnableJms
public class FlightSchedulerConfig {

	private static final Logger logger = Logger.getLogger(FlightSchedulerConfig.class.getName());

	public static final String QUEUE_NAME = "flightscheduler.queue";

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connectionFactory.setTrustedPackages(Arrays.asList("com.ibs.model","java.util","java.lang"));
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
	 * Used for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = null;
		try{
		template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(QUEUE_NAME);
		} catch (Exception exception) {
			logger.error("Error", exception);
		}
		return template;
	}
	/*
	 * Used for Message Converter.
	 */
	@Bean
	MessageConverter converter() {
		SimpleMessageConverter simpleMessageConverter = null;
		try{
			simpleMessageConverter = new SimpleMessageConverter();
		} catch (Exception exception) {
			logger.error("Error", exception);
		}
		return simpleMessageConverter;
	}
}
