package com.ibs.dto;

import java.io.Serializable;

/**
 * 
 * @author Sumya
 *
 */
public class FlightSearchDTO implements Serializable{
	
	private String departuredate;
	
	private String origin;
	
	private String destination;
	
	private String flightcode;
	
	private String connector;
	
	private String dierct;

	
	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public String getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightcode() {
		return flightcode;
	}

	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}

	public String getDierct() {
		return dierct;
	}

	public void setDierct(String dierct) {
		this.dierct = dierct;
	}

}
