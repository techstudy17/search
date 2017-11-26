package com.ibs.model;

import java.io.Serializable;

public class AvalilablityAndClassDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String bookingClass;
	private String availableSeats;
	public String getBookingClass() {
		return bookingClass;
	}
	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}
	
	/**
	 * @return the availableSeats
	 */
	public String getAvailableSeats() {
		return availableSeats;
	}
	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Avalilablity [bookingClass=" + bookingClass + ", available=" + availableSeats + "]";
	}
	
}
