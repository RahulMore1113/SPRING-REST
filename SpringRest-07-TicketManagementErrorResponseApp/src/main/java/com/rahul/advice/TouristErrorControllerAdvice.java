package com.rahul.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rahul.errorDetails.ErrorDetails;
import com.rahul.exception.TouristNotFountException;

@RestControllerAdvice
public class TouristErrorControllerAdvice {

	@ExceptionHandler(TouristNotFountException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFountException te) {

		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "404-NotFound");

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {

		System.out.println("TouristErrorControllerAdvice.handleAllProblems()");

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in Execution");

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
