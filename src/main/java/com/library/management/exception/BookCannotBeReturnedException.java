package com.library.management.exception;

public class BookCannotBeReturnedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int statusCode;

	public BookCannotBeReturnedException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public BookCannotBeReturnedException() {
		super();
	}

	public int getStatusCode() {
		return statusCode;
	}
}