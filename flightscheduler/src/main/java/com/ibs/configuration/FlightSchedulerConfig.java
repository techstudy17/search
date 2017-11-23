package com.ibs.configuration;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

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
		ConnectionFactory connectionFactory = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
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
}
