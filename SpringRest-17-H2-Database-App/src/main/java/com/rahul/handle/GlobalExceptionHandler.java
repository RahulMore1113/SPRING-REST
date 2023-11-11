package com.rahul.handle;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rahul.error.ErrorDetails;
import com.rahul.exception.StudentRecordNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentRecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundException(StudentRecordNotFoundException se) {

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), se.getMessage(), "Record Not Found");

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleOtherException(Exception e) {

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Internal Server Error");

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
