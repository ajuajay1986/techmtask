package com.techm.school.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.techm.school.exception.ResourceNotFoundException;


@ControllerAdvice
public class SchoolControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> studentNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("code", HttpStatus.NOT_FOUND.value());
        body.put("status", "Failed");
        body.put("error", ex.getMessage());
	    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	  }
}
