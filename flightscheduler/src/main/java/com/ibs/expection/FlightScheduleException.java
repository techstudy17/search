package com.ibs.expection;

/**
 * 
 * @author Sumya
 *
 */
public class FlightScheduleException extends Exception {
	private static final long serialVersionUID = 1L;
    private final String errorMessage;

    
    public FlightScheduleException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public FlightScheduleException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
