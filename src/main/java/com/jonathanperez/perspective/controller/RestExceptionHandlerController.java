package com.jonathanperez.perspective.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jonathanperez.perspective.dto.CustomErrorResponse;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandlerController {
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(ResourceNotFoundException exception){
		
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), 
																		exception.getMessage(), 
																		System.currentTimeMillis());
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exception){
		
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), 
																		exception.getMessage(), 
																		System.currentTimeMillis());
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
