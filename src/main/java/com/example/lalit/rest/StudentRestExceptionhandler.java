package com.example.lalit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionhandler {
	
	//Add the exception 
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe)
	{
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND) ;
	}
	
	//Generic Exception 
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe)
	{
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST) ;
	}
}
