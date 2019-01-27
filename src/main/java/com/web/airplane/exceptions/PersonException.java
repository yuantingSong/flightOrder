package com.web.airplane.exceptions;

public class PersonException extends Exception {

	public PersonException(String message)
	{
		super("UserException-"+message);
	}
	
	public PersonException(String message, Throwable cause)
	{
		super("UserException-"+message,cause);
	}
	
}
