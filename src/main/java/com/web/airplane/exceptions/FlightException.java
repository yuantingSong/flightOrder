package com.web.airplane.exceptions;

public class FlightException extends Exception {

	public FlightException(String message)
	{
		super("FlightException-"+message);
	}
	
	public FlightException(String message, Throwable cause)
	{
		super("FlightException-"+message,cause);
	}
	
}