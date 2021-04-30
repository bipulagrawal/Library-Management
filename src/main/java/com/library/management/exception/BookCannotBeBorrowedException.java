package com.library.management.exception;

public class BookCannotBeBorrowedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int statusCode;

	public BookCannotBeBorrowedException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public BookCannotBeBorrowedException() {
		super();
	}
	
	public int getStatusCode() {
		return statusCode;
	}

}