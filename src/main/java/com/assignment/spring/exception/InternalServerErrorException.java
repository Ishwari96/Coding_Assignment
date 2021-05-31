package com.assignment.spring.exception;

public class InternalServerErrorException extends RuntimeException {

	/**
	 * serialVersionUID for exception class
	 */
	private static final long serialVersionUID = 6390852392603009491L;

	public InternalServerErrorException(String message) {
		super(message);
	}
}
