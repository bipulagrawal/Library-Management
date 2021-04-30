package com.library.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.management.dto.ErrorDetailsDto;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(BookCannotBeBorrowedException.class)
	public ResponseEntity<ErrorDetailsDto> bookCannotBeBorrowedException(final Exception exception) {
		ErrorDetailsDto errorDetail = new ErrorDetailsDto(HttpStatus.BAD_REQUEST.value(),
				"Internal Server error", exception.getMessage());
		return new ResponseEntity<ErrorDetailsDto>(errorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookCannotBeReturnedException.class)
	public ResponseEntity<ErrorDetailsDto> bookCannotBeReturnedException(final Exception exception) {
		ErrorDetailsDto errorDetail = new ErrorDetailsDto(HttpStatus.BAD_REQUEST.value(),
				"Internal Server error", exception.getMessage());
		return new ResponseEntity<ErrorDetailsDto>(errorDetail, HttpStatus.BAD_REQUEST);
	}
}