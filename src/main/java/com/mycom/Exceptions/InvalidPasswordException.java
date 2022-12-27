package com.mycom.Exceptions;


public class InvalidPasswordException extends Exception{
	InvalidPasswordException(String msg)
	{
		super(msg);
	}
}