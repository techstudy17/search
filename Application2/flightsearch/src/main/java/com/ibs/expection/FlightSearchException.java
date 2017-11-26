package com.ibs.expection;

/**
 * 
 * @author Sumya
 *
 */
public class FlightSearchException extends Exception {
	private static final long serialVersionUID = 1L;
    private final String errorMessage;

    
    public FlightSearchException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public FlightSearchException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
