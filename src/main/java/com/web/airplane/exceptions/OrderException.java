package com.web.airplane.exceptions;

public class OrderException extends Exception {

	public OrderException(String message)
	{
		super("UserException-"+message);
	}
	
	public OrderException(String message, Throwable cause)
	{
		super("UserException-"+message,cause);
	}
	
}
