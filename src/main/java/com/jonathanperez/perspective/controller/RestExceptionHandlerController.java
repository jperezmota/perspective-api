package com.jonathanperez.perspective.controller;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jonathanperez.perspective.dto.CustomErrorResponseDTO;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandlerController {
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponseDTO> handleException(ResourceNotFoundException exception){
		
		CustomErrorResponseDTO customErrorResponse = new CustomErrorResponseDTO(HttpStatus.NOT_FOUND.value(), 
																		exception.getMessage(), 
																		System.currentTimeMillis());
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponseDTO> handleException(Exception exception){
		
		CustomErrorResponseDTO customErrorResponse = new CustomErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), 
																		exception.getMessage(), 
																		System.currentTimeMillis());
		
		return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponseDTO> handleValidationException(ValidationException validationException) {
		CustomErrorResponseDTO customErrorResponseDTO = new CustomErrorResponseDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(),
															validationException.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(customErrorResponseDTO, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
