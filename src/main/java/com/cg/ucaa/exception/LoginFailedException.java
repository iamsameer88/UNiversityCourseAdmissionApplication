package com.cg.ucaa.exception;

public class LoginFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LoginFailedException(String errMessage) {
		super(errMessage);
	}

}
