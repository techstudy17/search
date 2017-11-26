package com.ibs.dto;

import java.io.Serializable;

/**
 * 
 * @author Sumya
 *
 */
public class FlightSchedulerDTO implements Serializable{
	
	private String departuredate;
	
	private String origin;
	
	private String destination;
	
	private String flightnumber;
	
	private String bookingclass;
	
	private String availability;
	
	private String connector;
	
	private String careercode;

	
	/**
	 * @return the connector
	 */
	public String getConnector() {
		return connector;
	}

	/**
	 * @param connector the connector to set
	 */
	public void setConnector(String connector) {
		this.connector = connector;
	}

	/**
	 * @return the careercode
	 */
	public String getCareercode() {
		return careercode;
	}

	/**
	 * @param careercode the careercode to set
	 */
	public void setCareercode(String careercode) {
		this.careercode = careercode;
	}

	/**
	 * @return the departuredate
	 */
	public String getDeparturedate() {
		return departuredate;
	}

	/**
	 * @param departuredate the departuredate to set
	 */
	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the flightnumber
	 */
	public String getFlightnumber() {
		return flightnumber;
	}

	/**
	 * @param flightnumber the flightnumber to set
	 */
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}

	/**
	 * @return the bookingclass
	 */
	public String getBookingclass() {
		return bookingclass;
	}

	/**
	 * @param bookingclass the bookingclass to set
	 */
	public void setBookingclass(String bookingclass) {
		this.bookingclass = bookingclass;
	}

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightSchedulerDTO [departuredate=" + departuredate + ", origin=" + origin + ", destination="
				+ destination + ", flightnumber=" + flightnumber + ", bookingclass=" + bookingclass + ", availability="
				+ availability + "]";
	}

}
