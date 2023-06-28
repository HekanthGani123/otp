package com.example.generateotp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.twilio.exception.ApiException;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handleException(ApiException ex){
		String message = "Phone number is not verfied in twilio account or purchase paid version";
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
	}

}
