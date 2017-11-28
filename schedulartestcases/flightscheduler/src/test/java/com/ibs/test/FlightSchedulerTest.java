package com.ibs.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibs.dto.FlightSchedulerDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:flighrscheduler-servlet-test.xml" })
public class FlightSchedulerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testCurrencyConverterCaseOne() throws Exception {
		FlightSchedulerDTO flightSchedulerDTO = new FlightSchedulerDTO();
		flightSchedulerDTO.setOrigin("ban");
		flightSchedulerDTO.setDestination("del");
		flightSchedulerDTO.setDeparturedate("29/12/17");
		flightSchedulerDTO.setCareercode("in");
		flightSchedulerDTO.setConnector("goa");
		flightSchedulerDTO.setFlightnumber("23");
		flightSchedulerDTO.setBookingclass("A");
		flightSchedulerDTO.setAvailability("2");
		mockMvc.perform(post("/scheduleflight")
				.content(new ObjectMapper().writeValueAsString(flightSchedulerDTO))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
	}

	
}