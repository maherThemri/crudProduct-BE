package com.entretien.test1.handlers;


import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.entretien.test1.exceptions.ObjectValidationException;



@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ObjectValidationException.class)
	public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception) {
		ExceptionRepresentation representation = ExceptionRepresentation.builder()
				.errorMessage("Object not valid exception has occurred")
				.errorSource(exception.getViolationSource())
				.validationErrors(exception.getViolations())
				.build();
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(representation);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionRepresentation> handleException(EntityNotFoundException exception){
		ExceptionRepresentation representation = ExceptionRepresentation.builder()
				.errorMessage(exception.getMessage())
				.build();
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(representation);
	}
 
}
