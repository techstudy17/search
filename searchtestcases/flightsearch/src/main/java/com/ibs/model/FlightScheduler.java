package com.ibs.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sumya
 *
 */
@XmlRootElement  
public class FlightScheduler implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String departuredate;
	
	private String origin;
	
	private String destination;
	
	private String flightnumber;
	
	private String availabileClassAndSeats;
	
	private String connector;
	
	private String careercode;
	
	private List<AvalilablityAndClassDetails> avalilablityList;
	
	private Long scheduletime;
	
	public Long getScheduletime() {
		return scheduletime;
	}

	public void setScheduletime(Long scheduletime) {
		this.scheduletime = scheduletime;
	}

	/**
	 * @return the connector
	 */
	@XmlElement
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
	@XmlElement
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
	@XmlElement  
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
	@XmlElement  
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
	@XmlElement  
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
	@XmlElement  
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
	 * @return the availabileClassAndSeats
	 */
	public String getAvailabileClassAndSeats() {
		return availabileClassAndSeats;
	}

	/**
	 * @param availabileClassAndSeats the availabileClassAndSeats to set
	 */
	public void setAvailabileClassAndSeats(String availabileClassAndSeats) {
		this.availabileClassAndSeats = availabileClassAndSeats;
	}

	/**
	 * @return the avalilablityList
	 */
	public List<AvalilablityAndClassDetails> getAvalilablityList() {
		return avalilablityList;
	}

	/**
	 * @param avalilablityList the avalilablityList to set
	 */
	public void setAvalilablityList(List<AvalilablityAndClassDetails> avalilablityList) {
		this.avalilablityList = avalilablityList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightScheduler [departuredate=" + departuredate + ", origin=" + origin + ", destination=" + destination
				+ ", flightnumber=" + flightnumber + ", availabileClassAndSeats=" + availabileClassAndSeats
				+ ", connector=" + connector + ", careercode=" + careercode + ", avalilablityList=" + avalilablityList
				+ ", scheduletime=" + scheduletime + "]";
	}

}
