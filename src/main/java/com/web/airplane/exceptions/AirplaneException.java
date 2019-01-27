package com.web.airplane.exceptions;

public class AirplaneException extends Exception {

	public AirplaneException(String message)
	{
		super("AirplaneException-"+message);
	}
	
	public AirplaneException(String message, Throwable cause)
	{
		super("AirplaneException-"+message,cause);
	}
	
}